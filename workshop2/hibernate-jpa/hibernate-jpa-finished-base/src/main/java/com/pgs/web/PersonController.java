package com.pgs.web;

import com.pgs.dto.PersonDTO;
import com.pgs.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody
    public PersonDTO findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public PersonDTO add(@RequestBody PersonDTO personDTO) {
        return personService.add(personDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        personService.delete(id);
    }
}
