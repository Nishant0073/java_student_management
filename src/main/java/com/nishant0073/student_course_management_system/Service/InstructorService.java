package com.nishant0073.student_course_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant0073.student_course_management_system.Model.Instructor;
import com.nishant0073.student_course_management_system.Repository.InstructorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> GetInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor AddInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor GetInstructorById(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Instructor is not prsent with id:" + id));
    }
    public void DeleteInstructor(Long id){
        if(!instructorRepository.existsById(id)){
            throw new EntityNotFoundException("Instructor is not present with id:" + id);
        }
        instructorRepository.deleteById(id);
    }

    public Instructor UpdateInstructor(Long id, Instructor instructor) {
        return instructorRepository.findById(id).map( instr-> {
            instr.setName(instructor.getName());
            instr.setDepartment(instructor.getDepartment());
            return instructorRepository.save(instr);
        }).orElseThrow(() -> new RuntimeException("Instructor not found with this id:" + id));
    }

}