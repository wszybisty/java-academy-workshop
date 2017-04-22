package com.pgs.dto;

import java.sql.Date;
import java.util.List;

/**
 * Created by Luke on 2017-04-02.
 */
public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String gender;
    private Boolean enabled;
    private List<AddressDTO> addresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the addresses
     */
    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }
}
