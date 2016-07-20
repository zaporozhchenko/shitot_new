package com.shitot.model;

import javax.persistence.Entity;

/**
 * Created by Next on 20.07.2016.
 */
@Entity(name = "specialty")
public class Specialty extends NamedEntity{
    public Specialty() {
    }

    public Specialty(String name) {
        super(name);
    }
}
