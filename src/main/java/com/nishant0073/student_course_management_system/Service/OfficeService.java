package com.nishant0073.student_course_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant0073.student_course_management_system.Model.Office;
import com.nishant0073.student_course_management_system.Model.DTOs.OfficeDTO;
import com.nishant0073.student_course_management_system.Model.DTOs.OfficeRequestDTO;
import com.nishant0073.student_course_management_system.Repository.OfficeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    public List<OfficeDTO> GetOffices() {
        return officeRepository.findAll().stream().map((val) -> getOfficeDTO(val)).toList();
    }

    public OfficeDTO AddOffice(OfficeRequestDTO office) {

        Office newOffice = getNewOffice(office);

        Office createdOffice =  officeRepository.save(newOffice);

        OfficeDTO officeDTO = getOfficeDTO(createdOffice);

        return officeDTO;

    }

    public  Office GetOfficeById(Long id) {
        Office office =  officeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Office is not prsent with id:" + id));
        return office;
    }
    public void DeleteOffice(Long id){
        if(!officeRepository.existsById(id)){
            throw new EntityNotFoundException("Office is not present with id:" + id);
        }
        officeRepository.deleteById(id);
    }

    public OfficeDTO UpdateOffice(Long id, OfficeRequestDTO office) {

        Office updatedOffice  = officeRepository.findById(id).map(offc-> {
            offc.setRoomNumber(office.getRoomNumber());
            offc.setBuilding(office.getBuilding());
            return officeRepository.save(offc);
        }).orElseThrow(() -> new RuntimeException("Office not found with this id:" + id));
        return getOfficeDTO(updatedOffice);
    }

    private OfficeDTO getOfficeDTO(Office createdOffice) {
        OfficeDTO officeDTO = new OfficeDTO();
        officeDTO.setId(createdOffice.getId());
        officeDTO.setBuilding(createdOffice.getBuilding());
        officeDTO.setRoomNumber(createdOffice.getRoomNumber());
        return officeDTO;
    }

    private Office getNewOffice(OfficeRequestDTO office) {
        Office newOffice = new Office();
        newOffice.setBuilding(office.getBuilding());
        newOffice.setRoomNumber(office.getRoomNumber());
        return newOffice;
    }


}