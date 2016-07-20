package com.shitot.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Next on 12.07.2016.
 */
@Entity(name = "clinics")
public class Clinic extends NamedEntity{

    private String city;
    private String address;
    @OneToMany
    private List<Slot> slots;

    @ManyToOne
    private Doctor doctor;

    public Clinic() {
    }

    public Clinic(String name, String city) {
        super(name);
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
