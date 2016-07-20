package com.shitot.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 */
@Entity(name = "doctors")
public class Doctor extends NamedEntity {

    @OneToOne
    private Certificate certificate;
    private String comments;
    private String email;
    @OneToMany
    private Set<Expert> expertIn;
    private String lections;
    private String password;
    private String preferential;
    @OneToMany
    private Set<Specialty> specialties;
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "doctor_audience", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "target_audience")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<TargetAudience> targetAudiences;
    private String telAdditional;
    private String telNumber;

    @OneToMany(mappedBy = "doctor")
    private Set<Clinic> clinics;

    public Doctor() {
    }

    public Doctor(String name, Certificate certificate, String comments, String email,
                  Set<Expert> expertIn, String lections, String password, String preferential,
                  Set<Specialty> specialties, Set<TargetAudience> targetAudiences, String telAdditional,
                  String telNumber, Set<Clinic> clinics) {
        super(name);
        this.certificate = certificate;
        this.comments = comments;
        this.email = email;
        this.expertIn = expertIn;
        this.lections = lections;
        this.password = password;
        this.preferential = preferential;
        this.specialties = specialties;
        this.targetAudiences = targetAudiences;
        this.telAdditional = telAdditional;
        this.telNumber = telNumber;
        this.clinics = clinics;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Set<Clinic> getClinics() {
        return clinics;
    }

    public void setClinics(Set<Clinic> clinics) {
        this.clinics = clinics;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Expert> getExpertIn() {
        return expertIn;
    }

    public void setExpertIn(Set<Expert> expertIn) {
        this.expertIn = expertIn;
    }

    public String getLections() {
        return lections;
    }

    public void setLections(String lections) {
        this.lections = lections;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPreferential() {
        return preferential;
    }

    public void setPreferential(String preferential) {
        this.preferential = preferential;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Set<TargetAudience> getTargetAudiences() {
        return targetAudiences;
    }

    public void setTargetAudiences(Set<TargetAudience> targetAudiences) {
        this.targetAudiences = targetAudiences;
    }

    public String getTelAdditional() {
        return telAdditional;
    }

    public void setTelAdditional(String telAdditional) {
        this.telAdditional = telAdditional;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
