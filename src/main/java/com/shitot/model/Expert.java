package com.shitot.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by Next on 20.07.2016.
 */
@NamedQueries({
                  @NamedQuery(name = Expert.ALL_SORTED,query = "select e from experiences e order by e.name")
})
@Entity(name = "experiences")
public class Expert extends NamedEntity{
    public static final String ALL_SORTED = "Expert.getAllSorted";

    public Expert() {
    }

    public Expert(String name) {
        super(name);
    }
}
