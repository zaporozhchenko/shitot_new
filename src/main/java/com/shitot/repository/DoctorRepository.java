package com.shitot.repository;

import com.shitot.model.*;
import org.springframework.transaction.annotation.Transactional;

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

    List<TargetAudience> getAllTargetAudiences();

    void setCertificate(int id, String certificateName);
}
