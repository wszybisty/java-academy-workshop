package com.pgs.mapper;

import com.pgs.dto.AddressDTO;
import com.pgs.entity.Address;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * Created by Luke on 2017-04-06.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {


    AddressDTO toDto(Address address);

    Address toEntity(AddressDTO dto);
    
    List<AddressDTO> toDto(List<Address> personList);
}
