package com.pgs.repository;

import com.pgs.entity.Person;
import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */

public interface PersonRepository extends CrudRepository<Person, Long> {

    public void flush();

}
