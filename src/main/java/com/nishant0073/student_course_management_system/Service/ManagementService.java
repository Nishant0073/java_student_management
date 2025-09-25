package com.nishant0073.student_course_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant0073.student_course_management_system.Model.Course;
import com.nishant0073.student_course_management_system.Model.Student;
import com.nishant0073.student_course_management_system.Repository.CourseRepository;
import com.nishant0073.student_course_management_system.Repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ManagementService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student enrollStudentInCourse(Long studentId,Long courseId){
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student does not exist with id: "+studentId));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course does not exist with id: "+courseId));

        student.getCourses().add(course);
        course.getStudents().add(student);
        return studentRepository.save(student);
    }
    
}
