package com.shitot.service;

import com.shitot.model.Certificate;
import com.shitot.model.Doctor;
import com.shitot.model.Expert;
import com.shitot.model.Specialty;
import com.shitot.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Next on 21.07.2016.
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository repository;

    @Override
    public List<Doctor> getAll() {
        return repository.getAll();
    }

    @Override
    public Doctor get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return repository.getAllCertificates();
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        return repository.getAllSpecialties();
    }

    @Override
    public List<Expert> getAllExperiences() {
        return repository.getAllExperiences();
    }

    @Override
    public Doctor save(Doctor doctor) {
        doctor.setId(null);
        return repository.save(doctor);
    }
}
