package com.nishant0073.student_course_management_system.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nishant0073.student_course_management_system.Model.DTOs.InstructorDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Instructor {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 36)
    private String name;

    @Column(nullable = false,length = 36)
    private String department;

    @OneToMany(mappedBy = "instructor", orphanRemoval = true)
    List<Course> courses = new ArrayList<>();

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "address_id")
    private Office office;

    public Instructor() {
    }

    public Instructor(Long id, String name, String department) {
        super();
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Instructor(Long id,String name,String deparment,List<Course> courses){
        super();
        this.id = id;
        this.name = name;
        this.department = deparment;
        this.courses = courses;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public InstructorDTO toDTO() {
        return new InstructorDTO(this);
    }
}
