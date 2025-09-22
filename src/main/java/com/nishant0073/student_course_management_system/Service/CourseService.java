package com.nishant0073.student_course_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishant0073.student_course_management_system.Model.Course;
import com.nishant0073.student_course_management_system.Repository.CourseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> GetCourses() {
        return courseRepository.findAll();
    }

    public Course AddCourse(Course student) {
        return courseRepository.save(student);
    }

    public Course GetCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course is not prsent with id:" + id));
    }
    public void DeleteCourse(Long id){
        if(!courseRepository.existsById(id)){
            throw new EntityNotFoundException("Course is not present with id:" + id);
        }
        courseRepository.deleteById(id);
    }

    public Course UpdateCourse(Long id, Course course) {
        return courseRepository.findById(id).map(crs -> {
            crs.setCredit(course.getCredit());
            crs.setTitle(course.getTitle());
            return courseRepository.save(crs);
        }).orElseThrow(() -> new RuntimeException("Course not found with this id:" + id));
    }

}