package com.nishant0073.student_course_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant0073.student_course_management_system.Model.Student;
import com.nishant0073.student_course_management_system.Repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> GetStudents() {
        return studentRepository.findAll();
    }

    public Student AddStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student GetStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student is not prsent with id:" + id));
    }
    public void DeleteStudent(Long id){
        if(!studentRepository.existsById(id)){
            throw new EntityNotFoundException("Student is not present with id:" + id);
        }
        studentRepository.deleteById(id);
    }

    public Student UpdateStudent(Long id, Student student) {
        return studentRepository.findById(id).map(std -> {
            std.setName(student.getName());
            std.setEmail(student.getEmail());
            std.setAge(student.getAge());
            return studentRepository.save(std);
        }).orElseThrow(() -> new RuntimeException("Student not found with this id:" + id));
    }

}