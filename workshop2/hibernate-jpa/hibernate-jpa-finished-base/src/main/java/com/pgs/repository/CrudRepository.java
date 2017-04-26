package com.pgs.repository;

import java.util.List;

/**
 *
 * @author wszybisty
 */
public interface CrudRepository<E, ID> {

    E findById(ID id);

    List<E> findAll();

    E save(E entity);

    List<E> save(List<E> entities);

    void delete(ID id);

    void flush();
}
