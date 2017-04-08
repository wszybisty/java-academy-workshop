package com.pgs.hibernate.jpa.tests.service;

import com.pgs.hibernate.jpa.tests.model.Person;

/**
 *
 * @author wszybisty
 */
public interface PersonService {

    Person save(Person entity);

    Person merge(Person entity);

    Person findOne(Long id);

    Person saveAndFind(Person newPerson);
    
    Person findOneWithLock(Long id);

    Person findAndUpdateWithLock(Long personId, String lockedPersonName1);
}
