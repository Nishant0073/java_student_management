package com.nishant0073.student_course_management_system.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nishant0073.student_course_management_system.Model.Course;
import com.nishant0073.student_course_management_system.Model.DTOs.CourseDTO;
import com.nishant0073.student_course_management_system.Model.DTOs.CourseRequestDTO;
import com.nishant0073.student_course_management_system.Repository.CourseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> GetCourses() {
        return courseRepository.findAll().stream().map((val) -> val.toDTO()).toList();
    }

    public CourseDTO AddCourse(CourseRequestDTO course) {
        Course newCourse = getNewCourse(course);
        Course createdCourse =  courseRepository.save(newCourse);
        return createdCourse.toDTO();
    }



    public CourseDTO GetCourseById(Long id) {
        Course course  = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course is not prsent with id:" + id));

        return course.toDTO();
    }
    public void DeleteCourse(Long id){
        if(!courseRepository.existsById(id)){
            throw new EntityNotFoundException("Course is not present with id:" + id);
        }
        courseRepository.deleteById(id);
    }

    public CourseDTO UpdateCourse(Long id,CourseRequestDTO  course) {

        Course createdCourse =  courseRepository.findById(id).map(crs -> {
        crs.setTitle(course.getTitle());
        crs.setCredit(course.getCredit());
            return courseRepository.save(crs);
        }).orElseThrow(() -> new EntityNotFoundException("Course not found with this id:" + id));
        return createdCourse.toDTO();
    }

    private Course getNewCourse(CourseRequestDTO course) {
        Course newCourse = new Course();
        newCourse.setTitle(course.getTitle());
        newCourse.setCredit(course.getCredit());
        return newCourse;
    }
}