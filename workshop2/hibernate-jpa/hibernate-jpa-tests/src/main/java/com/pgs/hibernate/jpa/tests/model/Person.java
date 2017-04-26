package com.pgs.hibernate.jpa.tests.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 *
 * @author wszybisty
 */
@Entity
public class Person {
    
    @Id
    @GeneratedValue
    private Long personId;
    
    @Column
    private String name;
    
    @Version
    private int version;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{"
                + "\n\tpersonId = " + personId + ","
                + "\n\tname = " + name + ","
                + "\n\tversion = " + version + ""
                + "\n}";
    }    

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }
}
