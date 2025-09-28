package com.nishant0073.student_course_management_system.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant0073.student_course_management_system.Model.Student;
import com.nishant0073.student_course_management_system.Model.DTOs.StudentDTO;
import com.nishant0073.student_course_management_system.Model.DTOs.StudentRequestDTO;
import com.nishant0073.student_course_management_system.Repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public List<StudentDTO> GetStudents() {
        return studentRepository.findAll().stream().map((val) -> val.toDTO()).toList();
    }

    public StudentDTO AddStudent(StudentRequestDTO student) {

        Student newStudent = getStudent(student);
        Student createdStudent = studentRepository.save(newStudent);
        return createdStudent.toDTO();

    }

    public StudentDTO GetStudentById(Long id) {
        Student  student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student is not present with id:" + id));
        return student.toDTO();
    }

    public StudentDTO GetStudentByEmail(String email){
        Student  student = studentRepository.findStudentByEmail(email);
        if(student==null)
            throw new EntityNotFoundException("Student is not present with email:"+email);
        return student.toDTO();
    }

    public void DeleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student is not present with id:" + id);
        }
        studentRepository.deleteById(id);
    }

    public StudentDTO UpdateStudent(Long id, StudentRequestDTO student) {

        Student updatedStudent = studentRepository.findById(id).map(std -> {
            std.setName(student.getName());
            std.setEmail(student.getEmail());
            std.setAge(student.getAge());
            return studentRepository.save(std);
        }).orElseThrow(() -> new RuntimeException("Student not found with this id:" + id));
        return updatedStudent.toDTO();
    }

    private Student getStudent(StudentRequestDTO student) {
        Student newStudent = new Student();
        newStudent.setName(student.getName());
        newStudent.setAge(student.getAge());
        newStudent.setEmail(student.getEmail());
        return newStudent;
    }
}