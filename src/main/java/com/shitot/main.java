package com.shitot;

import com.shitot.model.*;
import com.shitot.repository.DoctorRepository;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

/**
 * Created by Next on 12.07.2016.
 */
public class main {
    private static final List<Doctor> DOCTORS = Arrays.asList(
    );

    public static void main(String[] args) {
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring-db.xml");
//            appCtx.load("spring-app.xml", "spring-db.xml", "spring-mvc.xml");
            appCtx.refresh();
            DoctorRepository repository = appCtx.getBean(DoctorRepository.class);
            Doctor doctor = new Doctor("doctor5", "doc5", "5", "doc5@mail", "123456789", "654321", "homeaddress5",
                                          "lections",
                                          "prefers", "comments");
            repository.save(doctor);
            repository.setCertificate(doctor.getId(), "Certificate1");
            repository.setSpecialties(doctor.getId(), "Specialty1", "Specialty3");
            repository.setTargetAudiences(doctor.getId(), "Children", "Teens", "Eldery");
            repository.setQualifications(doctor.getId(), "Qualification1", "Qualification2");
        }
    }

    private static void createSchedule(Doctor doc) {
    }

    private static void addClinic(Doctor doc, Clinic clinic) {
        for (Clinic c : doc.getClinics()) {
            if (clinic.getCity().equals(c.getCity())) {
                System.out.println("Can't add clinic. City.");
                return;
            }
        }
//        doc.getClinics().stream().forEach();
    }
}
