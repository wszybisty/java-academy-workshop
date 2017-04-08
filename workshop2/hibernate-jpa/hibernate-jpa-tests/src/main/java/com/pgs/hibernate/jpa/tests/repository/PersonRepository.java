package com.pgs.hibernate.jpa.tests.repository;

import com.pgs.hibernate.jpa.tests.model.Person;

/**
 *
 * @author wszybisty
 */
public interface PersonRepository extends CrudRepository<Person, Long>{

    Person findOneWithLock(Long id);
}
