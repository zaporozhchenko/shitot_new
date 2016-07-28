package com.shitot;

import com.shitot.model.*;
import com.shitot.repository.DoctorRepository;
import com.shitot.repository.DoctorRepositoryImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

import static com.shitot.model.TargetAudience.CHILDREN;
import static com.shitot.model.TargetAudience.ELDERY;
import static com.shitot.model.TargetAudience.TEENS;

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
            Doctor doctor = new Doctor("doctor5", "doc5", "5", "doc5@mail", "123456789", "654321", "lections",
                                          "prefers", "comments");
//            doctor.setCertificate(new Certificate("certif5"));
//            doctor.setExpertIn(new Expert(0,"expert51"),new Expert(1,"expert52"));
//            doctor.setTargetAudiences(CHILDREN,TEENS,ELDERY);
//            doctor.setSpecialties(new Specialty(0,"Specialty1"));
            doctor = repository.save(doctor);
            repository.setCertificate(doctor.getId(), "Certificate1");
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
