package com.shitot.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Next on 12.07.2016.
 */
@NamedQueries({
                  @NamedQuery(name = Doctor.ALL_SORTED,query = "select d from doctors d order by d.name")
})
@Entity(name = "doctors")
public class Doctor extends NamedEntity {

    public static final String ALL_SORTED = "Doctor.getAllSorted";
    private String comments;
    private String email;
    private String lections;
    private String login;
    private String password;
    private String preferential;
    private String telAdditional;
    private String telNumber;

    @OneToOne
    private Certificate certificate;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Expert> expertIn;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Specialty> specialties;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<TargetAudience> targetAudiences;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.EAGER)
    private Set<Clinic> clinics;

    public Doctor() {
    }

    public Doctor(Integer id, String name, String comments, String email, String lections, String login,
                  String password, String preferential, String telAdditional, String telNumber) {
        super(id, name);
        this.comments = comments;
        this.email = email;
        this.lections = lections;
        this.login = login;
        this.password = password;
        this.preferential = preferential;
        this.telAdditional = telAdditional;
        this.telNumber = telNumber;
    }

    public Doctor(Integer id, String name, Certificate certificate, String comments, String email,
                  Set<Expert> expertIn, String lections, String login, String password, String preferential,
                  Set<Specialty> specialties, Set<TargetAudience> targetAudiences, String telAdditional,
                  String telNumber) {
        super(id, name);
        this.certificate = certificate;
        this.comments = comments;
        this.email = email;
        this.expertIn = expertIn;
        this.lections = lections;
        this.login = login;
        this.password = password;
        this.preferential = preferential;
        this.specialties = specialties;
        this.targetAudiences = targetAudiences;
        this.telAdditional = telAdditional;
        this.telNumber = telNumber;
    }

    public Doctor(String name, String login, String password, String email, String telNumber, String telAdditional,
                  String lections, String preferential, String comments) {
        super(name);
        this.comments = comments;
        this.email = email;
        this.lections = lections;
        this.login = login;
        this.password = password;
        this.preferential = preferential;
        this.telAdditional = telAdditional;
        this.telNumber = telNumber;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
