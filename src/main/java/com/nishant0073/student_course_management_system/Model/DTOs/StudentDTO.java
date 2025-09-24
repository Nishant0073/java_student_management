package com.nishant0073.student_course_management_system.Model.DTOs;

import java.util.HashSet;
import java.util.Set;

public class StudentDTO {
    private Long id;    
    private String name;
    private String email;
    private int age;
    private Set<CourseDTO> courses = new HashSet<>();

    public StudentDTO() {
        super();
    }
    public StudentDTO(Long id, String name, String email, int age, Set<CourseDTO> courses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Set<CourseDTO> getCourses() {
        return courses;
    }
    public void setCourses(Set<CourseDTO> courses) {
        this.courses = courses;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }   

}