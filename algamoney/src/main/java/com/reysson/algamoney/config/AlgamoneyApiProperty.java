/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reysson.algamoney.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("algamoney")
public class AlgamoneyApiProperty {
    
    private String origemPermitida = "localhost:8000";

    public String getOrigemPermitida() {
        return origemPermitida;
    }

    public void setOrigemPermitida(String origemPermitida) {
        this.origemPermitida = origemPermitida;
    }
    
    
    private Seguranca seguranca = new Seguranca();
    
    public Seguranca getSeguranca(){
        return seguranca;
    }
    
    public class Seguranca{
        private Boolean enableHttps;

        public Boolean getEnableHttps() {
            return enableHttps;
        }

        public void setEnableHttps(Boolean enableHttps) {
            this.enableHttps = enableHttps;
        }
        
    }
}
