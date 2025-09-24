package com.nishant0073.student_course_management_system.Model.DTOs;

import javax.swing.text.View;

import com.fasterxml.jackson.annotation.JsonView;
import com.nishant0073.student_course_management_system.Model.Instructor;
import com.nishant0073.student_course_management_system.Model.Views;

public class CourseDTO {
    @JsonView(Views.Basic.class)
    private Long id;
    @JsonView(Views.Basic.class)
    private String title;
    @JsonView(Views.Basic.class)
    private int credit;
    @JsonView(Views.Detailed.class)
    private Instructor instructor;

    public CourseDTO() {
        super();
    }

    public CourseDTO(Long id, String title, int credit,Instructor instructor) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.instructor = instructor;
    }
    public CourseDTO(Long id, String title, int credit){
        this.id = id;
        this.title = title;
        this.credit = credit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    
}
