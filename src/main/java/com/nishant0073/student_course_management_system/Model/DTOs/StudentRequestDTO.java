package com.nishant0073.student_course_management_system.Model.DTOs;

import java.util.Set;

public class StudentRequestDTO {
    private String name;
    private int age;
    private String email;
    private Set<Long> courseIds;

    public Set<Long> getCourseIds() {
        return courseIds;
    }
    public void setCourseIds(Set<Long> courseIds) {
        this.courseIds = courseIds;
    }
    public StudentRequestDTO() {
        super();
    }   
    public StudentRequestDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
