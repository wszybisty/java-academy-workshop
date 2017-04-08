package com.pgs.hibernate.jpa.tests.repository;

import com.pgs.hibernate.jpa.tests.model.Person;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class PersonRepositoryHibernate implements PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person save(Person entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Person merge(Person entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public Person findOne(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public Person findOneWithLock(Long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.lock(person, LockModeType.PESSIMISTIC_WRITE);
        return person;
    }
}
