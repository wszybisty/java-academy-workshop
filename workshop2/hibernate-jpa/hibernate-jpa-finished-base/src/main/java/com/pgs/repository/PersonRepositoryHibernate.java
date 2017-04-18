package com.pgs.repository;

import com.pgs.entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryHibernate extends BaseRepositoryHibernate implements PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> rootEntry = cq.from(Person.class);
        CriteriaQuery<Person> all = cq.select(rootEntry);

        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public Person save(Person entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(Long id) {
        Person entityToDelete = entityManager.find(Person.class, id);
        if (entityToDelete != null) {
            entityManager.remove(entityToDelete);
        }
    }

    @Override
    public List<Person> save(List<Person> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flush() {
        entityManager.flush();
    }
    
    

}
