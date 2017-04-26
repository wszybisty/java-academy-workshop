package com.pgs.service;

import com.pgs.dto.AddressDTO;
import com.pgs.dto.PersonDTO;
import com.pgs.entity.Person;
import com.pgs.mapper.PersonMapper;
import com.pgs.repository.PersonRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<PersonDTO> findAll() {
        return personMapper.toDTO(personRepository.findAll());
    }

    @Override
    public PersonDTO findById(@PathVariable("id") String id) {
        return personMapper.toDTO(personRepository.findById(id));
    }

    @Override
    public PersonDTO add(PersonDTO personDTO) {
        final Person personEntity = personMapper.toEntity(personDTO);
        Person savedEntity = personRepository.save(personEntity);
        return personMapper.toDTO(savedEntity);
    }

    @Override
    public void delete(String id) {
        personRepository.delete(id);
    }

}
