package com.reysson.algamoney.token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken>{

    @Override
    public boolean supports(MethodParameter mp, Class<? extends HttpMessageConverter<?>> type) {
        
        return mp.getMethod().getName().equals("postAccessToken");
    }

    @Override
    public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken t, MethodParameter mp, MediaType mt,
            Class<? extends HttpMessageConverter<?>> type, ServerHttpRequest shr, ServerHttpResponse shr1) {
        
        //Para armazenar no cookie precisamos transformar em HttpServlet
        HttpServletRequest request = ((ServletServerHttpRequest) shr).getServletRequest();
        HttpServletResponse response = ((ServletServerHttpResponse) shr1).getServletResponse();
        
        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) t;
        
        //pegando o refresh token
        String refreshToken = t.getRefreshToken().getValue();
        adicionarRefreshTokenNoCookie(refreshToken, request, response);
        removerRefreshTokenDoBody(token);
        
        return t;
    }

    private void adicionarRefreshTokenNoCookie(String refreshToken, HttpServletRequest request,
            HttpServletResponse response) {
        
        Cookie cookie = new Cookie("refreshToken",refreshToken);
        cookie.setHttpOnly(true); 
        cookie.setSecure(false); //Mudar em produção
        cookie.setPath(request.getContextPath() + "/oauth/token");
        cookie.setMaxAge(2592000);
        response.addCookie(cookie);
    }

    private void removerRefreshTokenDoBody(DefaultOAuth2AccessToken token) {
        token.setRefreshToken(null);
    }
    
    
}
