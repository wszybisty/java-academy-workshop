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
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Luke on 2017-04-02.
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<PersonDTO> findAll() {
        return personMapper.toDTO(personRepository.findAll());
    }

    @Override
    public PersonDTO findById(@PathVariable("id") Long id) {
        return personMapper.toDTO(personRepository.findById(id));
    }

    @Override
    public PersonDTO add(PersonDTO personDTO) {
        final Person personEntity = personMapper.toEntity(personDTO);
        Person savedEntity = personRepository.save(personEntity);

        List<AddressDTO> savedAddresses = new ArrayList<>();
        final List<AddressDTO> addresses = personDTO.getAddresses();

        if (addresses != null) {
            for (AddressDTO address : addresses) {
                address.setPersonId(savedEntity.getId());
                AddressDTO savedAddress = addressService.add(address);
                savedAddresses.add(savedAddress);
            }
        }
        final PersonDTO dto = personMapper.toDTO(savedEntity);
        dto.setAddresses(savedAddresses);
        personRepository.flush();
        return dto;
    }

    @Override
    public void delete(Long id) {
        personRepository.delete(id);
    }

}
