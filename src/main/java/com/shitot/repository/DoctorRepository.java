package com.shitot.repository;

import com.shitot.model.Certificate;
import com.shitot.model.Doctor;
import com.shitot.model.Expert;
import com.shitot.model.Specialty;

import java.util.List;

/**
 * Created by Next on 21.07.2016.
 */
public interface DoctorRepository {
    Doctor save(Doctor doctor);

    List<Certificate> getAllCertificates();

    List<Specialty> getAllSpecialties();

    List<Expert> getAllExperiences();

    List<Doctor> getAll();

    Doctor get(int id);
}
