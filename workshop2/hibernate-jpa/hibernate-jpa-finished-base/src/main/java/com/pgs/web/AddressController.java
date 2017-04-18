package com.pgs.web;

import com.pgs.dto.AddressDTO;
import com.pgs.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<AddressDTO> findAll() {
        return addressService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    public AddressDTO findById(@PathVariable("id") Long id) {
        return addressService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public AddressDTO add(@RequestBody AddressDTO personDTO) {
        return addressService.add(personDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public AddressDTO update(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) {
        if (!id.equals(addressDTO.getId())) {
            throw new RuntimeException("400 Bad Request");
        }
        return addressService.update(addressDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        addressService.delete(id);
    }
}
