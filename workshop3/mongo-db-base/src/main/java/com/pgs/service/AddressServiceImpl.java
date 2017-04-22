package com.pgs.service;

import com.pgs.dto.AddressDTO;
import com.pgs.entity.Address;
import com.pgs.mapper.AddressMapper;
import com.pgs.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressDTO> findAll() {
        return addressMapper.toDto(addressRepository.findAll());
    }

    @Override
    public AddressDTO findById(@PathVariable("id") Long id) {
        return addressMapper.toDto(addressRepository.findById(id));
    }

    @Override
    public AddressDTO add(AddressDTO addressDTO) {
        final Address addressEntity = addressMapper.toEntity(addressDTO);
        Address savedEntity = addressRepository.save(addressEntity);
        return addressMapper.toDto(savedEntity);
    }

    @Override
    public void delete(Long id) {
        addressRepository.delete(id);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        final Address addressEntity = addressMapper.toEntity(addressDTO);
        Address savedEntity = addressRepository.merge(addressEntity);
        return addressMapper.toDto(savedEntity);
    }


}
