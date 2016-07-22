package com.shitot.model;

import javax.persistence.MappedSuperclass;

/**
 * Created by Next on 20.07.2016.
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    protected String name;

    protected NamedEntity() {
    }

    public NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    protected NamedEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
