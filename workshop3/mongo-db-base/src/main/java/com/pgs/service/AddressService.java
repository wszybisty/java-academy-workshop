package com.pgs.service;

import com.pgs.dto.AddressDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
public interface AddressService {
    List<AddressDTO> findAll();

    AddressDTO findById(@PathVariable("id") Long id);

    AddressDTO add(AddressDTO personDTO);

    void delete(Long id);

    public AddressDTO update(AddressDTO personDTO);
}
