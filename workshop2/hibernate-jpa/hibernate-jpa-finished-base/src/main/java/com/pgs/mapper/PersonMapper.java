package com.pgs.mapper;

import com.pgs.dto.PersonDTO;
import com.pgs.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({
            @Mapping(source = "dateOfBirth", target = "birthday"),
            @Mapping(source = "active", target = "enabled")
    })
    PersonDTO toDTO(Person person);

    @Mappings({
            @Mapping(source = "birthday", target = "dateOfBirth"),
            @Mapping(source = "enabled", target = "active")
    })
    Person toEntity(PersonDTO dto);

    List<PersonDTO> toDTO(List<Person> personList);
}
