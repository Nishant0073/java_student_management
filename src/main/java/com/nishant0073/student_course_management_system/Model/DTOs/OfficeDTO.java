package com.nishant0073.student_course_management_system.Model.DTOs;

public class OfficeDTO {
    private Long id;
    private Long roomNumber;
    private String building;

    public OfficeDTO() {
        super();
    }   
    public OfficeDTO(Long id, Long roomNumber, String building) {
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