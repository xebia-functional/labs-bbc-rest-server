package com.fortysevendeg.labs.bbc.rest.services.persistence.jpa;

import com.fortysevendeg.labs.bbc.rest.model.PersistentObject;
import com.fortysevendeg.labs.bbc.rest.services.persistence.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

/**
 * JPA based impl for the @see PersistenceService
 */
@Service("JPA")
public class JPAPersistenceServiceImpl implements PersistenceService {

    @PersistenceContext
    private EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(JPAPersistenceServiceImpl.class);

    @Override
    public <T extends PersistentObject> long count(Class<T> entityClass) {
        long count;
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        Root root = cq.from(entityClass);
        cq.select(qb.count(root));
        count = em.createQuery(cq).getSingleResult();
        return count;
    }

    @Override
    public <T extends PersistentObject> Collection<T> list(Class<T> entityClass) {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<T> recordsQuery = qb.createQuery(entityClass);
        Root<T> root = recordsQuery.from(entityClass);
        recordsQuery.select(root);
        TypedQuery<T> query = em.createQuery(recordsQuery);
        return query.getResultList();
    }

    @Override
    @Transactional
    public <T extends PersistentObject> T create(T entity) {
        return em.merge(entity);
    }

    @Override
    public <T extends PersistentObject> T read(Class<T> entityClass, Long id) {
        return em.find(entityClass, id);
    }

    @Override
    @Transactional
    public <T extends PersistentObject> T update(T entity) {
        return em.merge(entity);
    }

    @Override
    @Transactional
    public <T extends PersistentObject> T delete(Class<T> entityClass, Long id) {
        T entity = read(entityClass, id);
        em.remove(entity);
        return entity;
    }
}
