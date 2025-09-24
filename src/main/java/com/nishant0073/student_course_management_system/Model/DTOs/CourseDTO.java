package com.nishant0073.student_course_management_system.Model.DTOs;

public class CourseDTO {
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String title;
    private int credit;
    public CourseDTO() {
        super();
    }

    public CourseDTO(Long id, String title, int credit) {
        this.id = id;
        this.title = title;
        this.credit = credit;
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
    
}
