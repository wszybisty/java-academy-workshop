package com.pgs.repository;

import com.pgs.entity.Address;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepositoryHibernate extends BaseRepositoryHibernate implements AddressRepository {

    @Override
    public Address findById(Long id) {
        return entityManager.find(Address.class, id);
    }

    @Override
    public List<Address> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Address> cq = cb.createQuery(Address.class);
        Root<Address> rootEntry = cq.from(Address.class);
        CriteriaQuery<Address> all = cq.select(rootEntry);

        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public Address save(Address entity) {
        entityManager.persist(entity);
        //throw new RuntimeException();
        return entity;
    }

    @Override
    public void delete(Long id) {
        Address entityToDelete = entityManager.find(Address.class, id);
        if (entityToDelete != null) {
            entityManager.remove(entityToDelete);
        }
    }

    @Override
    public List<Address> save(List<Address> entities) {
        return null;
    }

    @Override
    public void flush() {
        entityManager.flush();
    }

    @Override
    public Address merge(Address entity) {
        return entityManager.merge(entity);
    }
    
}
