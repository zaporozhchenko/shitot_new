package com.shitot.service;

import com.shitot.model.Certificate;
import com.shitot.model.Doctor;
import com.shitot.model.Expert;
import com.shitot.model.Specialty;

import java.util.List;

/**
 * Created by Next on 21.07.2016.
 */
public interface DoctorService {

    Doctor save(Doctor doctor);

    List<Specialty> getAllSpecialties();

    List<Expert> getAllExperiences();

    List<Certificate> getAllCertificates();

    List<Doctor> getAll();

    Doctor get(int id);
}
