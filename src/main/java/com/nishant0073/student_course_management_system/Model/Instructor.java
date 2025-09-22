package com.nishant0073.student_course_management_system.Model;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Instructor {

    @Id
    private Long id;
    private String name;
    private String department;

    public Instructor() {
    }

    public Instructor(Long id, String name, String department) {
        super();
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Optional<Instructor> findById(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
