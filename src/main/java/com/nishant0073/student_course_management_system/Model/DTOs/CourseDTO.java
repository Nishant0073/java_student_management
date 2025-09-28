package com.nishant0073.student_course_management_system.Model.DTOs;

import com.nishant0073.student_course_management_system.Model.Course;

public class CourseDTO {
    private Long id;
    private String title;
    private int credit;
    private InstructorDTO instructor;

    public CourseDTO() {
        super();
    }

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.credit = course.getCredit();
        //this.instructor = course.getInstructor() != null ? course.getInstructor().toDTO() : null;
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

    public InstructorDTO getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorDTO instructor) {
        this.instructor = instructor;
    }

}
