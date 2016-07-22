package com.shitot.web.doctor;

import com.shitot.model.Doctor;
import com.shitot.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * Created by Next on 21.07.2016.
 */
public class AbstractDoctorController {

    @Autowired
    DoctorService service;

    public Doctor create(Doctor doctor){
        return service.save(doctor);
    }

    public Doctor get(int id) {
        return service.get(id);
    }
}
