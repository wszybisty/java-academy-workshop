package com.pgs.hibernate.jpa.tests.repository;

/**
 *
 * @author wszybisty
 */
public interface CrudRepository <T, ID> {
    T save(T entity);
    
    T merge(T entity);
    
    T findOne(ID id);
}
