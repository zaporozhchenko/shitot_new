package com.shitot.model;

import javax.persistence.Entity;

/**
 * Created by Next on 20.07.2016.
 */
@Entity(name = "certificates")
public class Certificate extends NamedEntity{

    public Certificate() {
    }

    public Certificate(String name) {
        super(name);
    }
}
