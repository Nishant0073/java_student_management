package com.nishant0073.student_course_management_system.Model.DTOs;

public class CourseRequestDTO {
    private String title;
    private int credit;
    private Long instructorId;
    public CourseRequestDTO() {
        super();
    }

    public CourseRequestDTO(String title, int credit,Long instructorId) {
        this.title = title;
        this.credit = credit;
        this.instructorId = instructorId;
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

    public Long getinstructorId() {
        return instructorId;
    }

    public void setinstructorId(Long instructor) {
        this.instructorId = instructor;
    }
}
