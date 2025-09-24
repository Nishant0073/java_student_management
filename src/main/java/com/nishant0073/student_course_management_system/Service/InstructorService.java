package com.nishant0073.student_course_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant0073.student_course_management_system.Model.Instructor;
import com.nishant0073.student_course_management_system.Model.DTOs.InstructorDTO;
import com.nishant0073.student_course_management_system.Model.DTOs.InstructorRequestDTO;
import com.nishant0073.student_course_management_system.Repository.InstructorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> GetInstructors() {
        return instructorRepository.findAll();
    }


    public InstructorDTO AddInstructor(InstructorRequestDTO instructor) {

            Instructor newInstructor = getNewInstructor(instructor);

            Instructor createdInstructor =  instructorRepository.save(newInstructor);

            return getInstructorDTO(createdInstructor);
    }

    public InstructorDTO GetInstructorById(Long id) {
        Instructor instructor =  instructorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Instructor is not prsent with id:" + id));
        return getInstructorDTO(instructor);
    }
    public void DeleteInstructor(Long id){
        if(!instructorRepository.existsById(id)){
            throw new EntityNotFoundException("Instructor is not present with id:" + id);
        }
        instructorRepository.deleteById(id);
    }

    public InstructorDTO UpdateInstructor(Long id, InstructorRequestDTO instructor) {

        Instructor CreatedInstructor = instructorRepository.findById(id).map( instr-> {
            instr.setName(instructor.getName());
            instr.setDepartment(instructor.getDepartment());
            return instructorRepository.save(instr);
        }).orElseThrow(() -> new RuntimeException("Instructor not found with this id:" + id));

        return getInstructorDTO(CreatedInstructor);
    }

    private InstructorDTO getInstructorDTO(Instructor createdInstructor) {
        InstructorDTO instructorDTO = new InstructorDTO();
        instructorDTO.setId(createdInstructor.getId());
        instructorDTO.setName(createdInstructor.getName());
        instructorDTO.setDepartment(createdInstructor.getDepartment());
        return instructorDTO;
    }

    private Instructor getNewInstructor(InstructorRequestDTO instructor) {
        Instructor newInstructor = new Instructor();
        newInstructor.setName(instructor.getName());
        newInstructor.setDepartment(instructor.getDepartment());
        return newInstructor;
    }

}