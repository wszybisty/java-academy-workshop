package com.pgs.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wszybisty
 */
@Transactional
public abstract class BaseRepositoryHibernate {
    
    @PersistenceContext
    protected EntityManager entityManager;
    
}
