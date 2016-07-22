package com.shitot.repository;

import com.shitot.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Next on 21.07.2016.
 */
@Repository
@Transactional(readOnly = true)
public class DoctorRepositoryImpl implements DoctorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Doctor save(Doctor doctor) {
        if (doctor.isNew()) {
            em.persist(doctor.getCertificate());
//            em.persist(doctor);
            return doctor;
        } else return em.merge(doctor);
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return em.createNamedQuery(Certificate.ALL_SORTED, Certificate.class).getResultList();
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        return em.createNamedQuery(Specialty.ALL_SORTED, Specialty.class).getResultList();
    }

    @Override
    public List<Expert> getAllExperiences() {
        return em.createNamedQuery(Expert.ALL_SORTED, Expert.class).getResultList();
    }

    @Override
    public List<Doctor> getAll() {
        return em.createNamedQuery(Doctor.ALL_SORTED, Doctor.class).getResultList();
    }

    @Override
    public Doctor get(int id) {
        return em.find(Doctor.class, id);
    }
}
