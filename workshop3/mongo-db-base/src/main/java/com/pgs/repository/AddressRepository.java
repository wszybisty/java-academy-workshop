package com.pgs.repository;

import com.pgs.entity.Address;

/**
 *
 * @author wszybisty
 */
public interface AddressRepository extends CrudRepository<Address, Long> {

    public Address merge(Address addressEntity);
    
}
