package com.nishant0073.student_course_management_system.Model.DTOs;

public class InstructorRequestDTO {
    private String name;
    private String department;

    public InstructorRequestDTO() {
        super();
    }   
    public InstructorRequestDTO(String name, String department) {
        this.name = name;
        this.department = department;
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
}
