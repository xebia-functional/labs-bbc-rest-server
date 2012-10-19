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
    private String description;

    private double avb;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String lastName) {
        this.description = lastName;
    }

    public double getAvb() {
        return avb;
    }

    public void setAvb(double avb) {
        this.avb = avb;
    }
}
