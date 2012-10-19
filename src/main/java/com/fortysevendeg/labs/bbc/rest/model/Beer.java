package com.fortysevendeg.labs.bbc.rest.model;

import javax.persistence.*;

@Entity
public class Beer implements PersistentObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String upc;

    public Beer() {
    }

    public Beer(Long id, String name, String upc) {
        this(name, upc);
        this.id = id;
    }

    public Beer(String name, String upc) {
        this.name = name;
        this.upc = upc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String lastName) {
        this.upc = lastName;
    }
}
