package com.example.deverus.linkedin.manageprofile.entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Enumerated;
import javax.persistence.EnumType;


@Entity
@Table(name="profiles")
@Validated
public class Profile {

    @Id
    private int id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public JobStatus getJobstatus() {
        return jobStatus;
    }

    public void setJobstatus(JobStatus jobstatus) {
        this.jobStatus = jobstatus;
    }


}
