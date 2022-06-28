package org.launchcode.techjobs.persistent.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

//mapping info applied to the entities that inherit from it, no separate table defined
@MappedSuperclass
public abstract class AbstractEntity {

//primary key, unique identifier of current entity and increment
    @Id
    @GeneratedValue
    private int id;

//a user cannot leave this field blank when creating an object.
//name field will be shared across Job, Employer, and Skill classes. Some employer names might be longer than 50 characters.
    @NotBlank(message = "Name is required.")
    @Size(min=1, max = 100, message = "Maximum character length is 100.")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}