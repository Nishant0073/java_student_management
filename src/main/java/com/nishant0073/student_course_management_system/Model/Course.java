package com.nishant0073.student_course_management_system.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {

    @Id
    private Long id;
    @Column(nullable = false, unique = true,length = 255)
    private String title;
    @Column(nullable = false)
    private int credit;

    public Course() {};

    @SuppressWarnings("unused")
    private Course(Long id, String title, int credit) {
        super();
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

}
