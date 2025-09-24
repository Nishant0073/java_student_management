package com.nishant0073.student_course_management_system.Model.DTOs;

public class CourseRequestDTO {
    private String title;
    private int credit;
    public CourseRequestDTO() {
        super();
    }

    public CourseRequestDTO(String title, int credit) {
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
