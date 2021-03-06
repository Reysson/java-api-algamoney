package com.reysson.algamoney.repository.implementacao;

import com.reysson.algamoney.dto.LancamentoEstatiscaCategoria;
import com.reysson.algamoney.dto.LancamentoEstatiscaDia;
import com.reysson.algamoney.model.Lancamento;
import com.reysson.algamoney.repository.filter.LancamentoFilter;
import com.reysson.algamoney.repository.projecao.LancamentoResumo;
import com.reysson.algamoney.repository.query.LancamentoRepositoryQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        Predicate[] predicate = criarRestricoes(lancamentoFilter, builder, root);
        criteria.where(predicate);

        TypedQuery<Lancamento> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
    }

    @Override
    public Page<LancamentoResumo> buscar(LancamentoFilter lancamentoFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<LancamentoResumo> criteria = builder.createQuery(LancamentoResumo.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        criteria.select(builder.construct(LancamentoResumo.class,
                root.get("codigo"), root.get("descricao"),
                root.get("dataVencimento"), root.get("dataPagamento"),
                root.get("valor"),
                root.get("categoria").get("nome"),
                root.get("pessoa").get("nome")));

        Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<LancamentoResumo> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
    }

    @Override
    public List<LancamentoEstatiscaDia> porDia(LocalDate mesReferencia) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

        CriteriaQuery<LancamentoEstatiscaDia> criteriaQuery = criteriaBuilder.
                createQuery(LancamentoEstatiscaDia.class);

        Root<Lancamento> root = criteriaQuery.from(Lancamento.class);

        criteriaQuery.select(criteriaBuilder.construct(LancamentoEstatiscaDia.class,
                root.get("tipo"),
                root.get("dataVencimento"),
                criteriaBuilder.sum(root.get("valor"))));

        LocalDate primeiroDia = mesReferencia.withDayOfMonth(1);
        LocalDate ultimoDia = mesReferencia.withDayOfMonth(mesReferencia.lengthOfMonth());

        criteriaQuery.where(
                criteriaBuilder.greaterThanOrEqualTo(root.get("dataVencimento"),
                        primeiroDia),
                criteriaBuilder.lessThanOrEqualTo(root.get("dataVencimento"),
                        ultimoDia));

        criteriaQuery.groupBy(root.get("tipo"),
                root.get("dataVencimento"));

        TypedQuery<LancamentoEstatiscaDia> typedQuery = manager
                .createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }

    @Override
    public List<LancamentoEstatiscaCategoria> porCategoria(LocalDate data) {

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

        CriteriaQuery<LancamentoEstatiscaCategoria> criteriaQuery = criteriaBuilder.
                createQuery(LancamentoEstatiscaCategoria.class);

        Root<Lancamento> root = criteriaQuery.from(Lancamento.class);

        criteriaQuery.select(criteriaBuilder.construct(LancamentoEstatiscaCategoria.class,
                root.get("categoria"),
                criteriaBuilder.sum(root.get("valor"))));

        LocalDate primeiroDia = data.withDayOfMonth(1);
        LocalDate ultimoDia = data.withDayOfMonth(data.lengthOfMonth());

        criteriaQuery.where(
                criteriaBuilder.greaterThanOrEqualTo(root.get("dataVencimento"),
                        primeiroDia),
                criteriaBuilder.lessThanOrEqualTo(root.get("dataVencimento"),
                        ultimoDia));

        criteriaQuery.groupBy(root.get("categoria"));

        TypedQuery<LancamentoEstatiscaCategoria> typedQuery = manager
                .createQuery(criteriaQuery);

        return typedQuery.getResultList();

    }

    private Predicate[] criarRestricoes(LancamentoFilter lancamentoFilter, CriteriaBuilder builder, Root<Lancamento> root) {

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(lancamentoFilter.getDescricao())) {
            predicates.add(builder.like(builder.lower(root.get("descricao")), "%" + lancamentoFilter.getDescricao().toLowerCase() + "%"));
        }

        if (lancamentoFilter.getDataVencimentoDe() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("dataVencimento"), lancamentoFilter.getDataVencimentoDe()));
        }

        if (lancamentoFilter.getDataVencimentoAte() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("dataVencimento"), lancamentoFilter.getDataVencimentoAte()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    Long total(LancamentoFilter filter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Lancamento> root = query.from(Lancamento.class);

        Predicate[] predicates = criarRestricoes(filter, builder, root);

        query.where(predicates);

        query.select(builder.count(root));

        return manager.createQuery(query).getSingleResult();

    }

}
