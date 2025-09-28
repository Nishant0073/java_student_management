package com.nishant0073.student_course_management_system.Model.DTOs;

import com.nishant0073.student_course_management_system.Model.Student;

public class StudentDTO {
    private Long id;    
    private String name;
    private String email;
    private int age;

    public StudentDTO() {
        super();
    }

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.age = student.getAge();
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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }   

}