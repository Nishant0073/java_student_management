package com.nishant0073.student_course_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant0073.student_course_management_system.Model.Office;
import com.nishant0073.student_course_management_system.Repository.OfficeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    public List<Office> GetOffices() {
        return officeRepository.findAll();
    }

    public Office AddOffice(Office office) {
        return officeRepository.save(office);
    }

    public  Office GetOfficeById(Long id) {
        return officeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Office is not prsent with id:" + id));
    }
    public void DeleteOffice(Long id){
        if(!officeRepository.existsById(id)){
            throw new EntityNotFoundException("Office is not present with id:" + id);
        }
        officeRepository.deleteById(id);
    }

    public Office UpdateOffice(Long id, Office office) {
        return officeRepository.findById(id).map(offc-> {
            offc.setRoomNumber(office.getRoomNumber());
            offc.setBuilding(office.getBuilding());
            return officeRepository.save(offc);
        }).orElseThrow(() -> new RuntimeException("Office not found with this id:" + id));
    }

}