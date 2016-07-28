package com.shitot.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Arrays;

/**
 * Created by Next on 20.07.2016.
 */
@NamedQueries({
                  @NamedQuery(name = TargetAudience.ALL_SORTED, query = "select t from audiences t order by t.name")
})
@Entity(name = "audiences")
public class TargetAudience extends NamedEntity {

    public static final String ALL_SORTED = "TargetAudience.getAllSorted";
    public static final TargetAudience CHILDREN = new TargetAudience(0,"Children");
    public static final TargetAudience TEENS = new TargetAudience(1,"Teens");
    public static final TargetAudience ADULTS = new TargetAudience(2,"Adults");
    public static final TargetAudience ELDERY = new TargetAudience(3,"Eldery");

    public TargetAudience() {
    }

    public TargetAudience(String name) {
        super(name);
    }

    public TargetAudience(Integer id, String name) {
        super(id, name);
    }
}
