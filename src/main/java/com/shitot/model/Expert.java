package com.shitot.model;

import javax.persistence.Entity;

/**
 * Created by Next on 20.07.2016.
 */
@Entity(name = "expert")
public class Expert extends NamedEntity{
    public Expert() {
    }

    public Expert(String name) {
        super(name);
    }
}
