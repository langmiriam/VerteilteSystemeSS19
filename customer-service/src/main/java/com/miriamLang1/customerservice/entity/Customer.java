package com.miriamLang1.customerservice.serviceImpl;

import javax.persistence.*;

@Entity
@Table (name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String forename;
    private String lastname;
    private String username;
    private String email;

    public Customer() {
    }

    public Customer(String forename, String lastname, String username, String email) {
        this.forename = forename;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
