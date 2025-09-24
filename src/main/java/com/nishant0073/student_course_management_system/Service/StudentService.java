package com.nishant0073.student_course_management_system.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant0073.student_course_management_system.Model.Course;
import com.nishant0073.student_course_management_system.Model.Student;
import com.nishant0073.student_course_management_system.Model.DTOs.StudentDTO;
import com.nishant0073.student_course_management_system.Model.DTOs.StudentRequestDTO;
import com.nishant0073.student_course_management_system.Repository.CourseRepository;
import com.nishant0073.student_course_management_system.Repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<StudentDTO> GetStudents() {
        return studentRepository.findAll().stream().map((val) -> getStudentDTO(val)).toList();
    }

    public StudentDTO AddStudent(StudentRequestDTO student) {

        Student newStudent = getStudent(student);

        Student createdStudent = studentRepository.save(newStudent);
        StudentDTO studentDTO = getStudentDTO(createdStudent);

        return studentDTO;

    }

    public StudentDTO GetStudentById(Long id) {
        Student creaStudent = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student is not prsent with id:" + id));
        return getStudentDTO(creaStudent);
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

        return getStudentDTO(updatedStudent);
    }

    private StudentDTO getStudentDTO(Student createdStudent) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(createdStudent.getId());
        studentDTO.setName(createdStudent.getName());
        studentDTO.setAge(createdStudent.getAge());
        studentDTO.setEmail(createdStudent.getEmail());
        return studentDTO;
    }

    private Student getStudent(StudentRequestDTO student) {
        Student newStudent = new Student();

        newStudent.setName(student.getName());
        newStudent.setAge(student.getAge());
        newStudent.setEmail(student.getEmail());
         Set<Course> courses = student.getCourseIds().stream()
            .map(id -> courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found: " + id)))
            .collect(Collectors.toSet());
        newStudent.setCourses(courses);
        return newStudent;
    }
}