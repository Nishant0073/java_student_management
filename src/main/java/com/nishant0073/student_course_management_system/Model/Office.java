package com.nishant0073.student_course_management_system.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Office {

    @Id
    private Long id;

    @Column(nullable = false,unique = true)
    private Long roomNumber;
    @Column(nullable = false, length=36)
    private String building;

    public Office(){};

    public Office(Long id,Long roomNumber,String building) {
        super();
        this.id = id;
        this.roomNumber = roomNumber;
        this.building = building;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getBuilding() {
        return building;
    }
    public void setBuilding(String building) {
        this.building = building;
    }


}
