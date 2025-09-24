package com.nishant0073.student_course_management_system.Model.DTOs;

public class OfficeRequestDTO {
    private Long roomNumber;
    private String building;

    public OfficeRequestDTO() {
        super();
    }   
    public OfficeRequestDTO(Long roomNumber, String building) {
        this.roomNumber = roomNumber;
        this.building = building;
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
