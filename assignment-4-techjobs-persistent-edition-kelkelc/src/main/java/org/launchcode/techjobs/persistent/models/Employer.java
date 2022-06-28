package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//table in database
@Entity
public class Employer extends AbstractEntity {

// Add the field for location with validation that ensures it is not empty and has a reasonable length.
    @NotBlank(message = "Location is required.")
    @Size(min=1, max = 100, message = "Maximum character length is 100.")
    private String location;

//    Employer may contain several jobs
    @OneToMany
    @JoinColumn(name = "employer_id")
//    represent the list of all items in a given job
    private final List<Job> jobs = new ArrayList<>();

//    no arg constructor
    public Employer() {}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    list the jobs associated with each instance
    public List<Job> getJobs() {
        return jobs;
    }

}