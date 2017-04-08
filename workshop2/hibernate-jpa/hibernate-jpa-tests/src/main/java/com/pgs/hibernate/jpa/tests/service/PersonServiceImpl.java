package com.pgs.hibernate.jpa.tests.service;

import com.pgs.hibernate.jpa.tests.model.Person;
import com.pgs.hibernate.jpa.tests.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    
    @Override
    public Person save(Person entity) {
        return personRepository.save(entity);
    }

    @Override
    public Person merge(Person entity) {
        return personRepository.merge(entity);
    }

    @Override
    public Person findOne(Long id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person saveAndFind(Person newPerson) {
        Person saved = personRepository.save(newPerson);
        return personRepository.findOne(saved.getPersonId());
    }

    @Override
    public Person findOneWithLock(Long id) {
        return personRepository.findOneWithLock(id);
    }

    @Override
    public Person findAndUpdateWithLock(Long personId, String lockedPersonName1) {
        Person lockedEntity = personRepository.findOneWithLock(personId);
        lockedEntity.setName(lockedPersonName1);
        return personRepository.save(lockedEntity);
    }
    
    
}
