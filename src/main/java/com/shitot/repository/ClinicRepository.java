package com.shitot.repository;

import com.shitot.model.*;

import java.util.List;

/**
 * Created by Next on 21.07.2016.
 */
public interface ClinicRepository {
    Clinic save(Clinic clinic);

    List<Slot> getAllSlots();

    List<Clinic> getAll();

    List<Clinic> getByCity(String specialty);

    List<Clinic> getByDoctor(String qualification);


    Clinic get(int id);

    void setSlot(Slot slot);

}
