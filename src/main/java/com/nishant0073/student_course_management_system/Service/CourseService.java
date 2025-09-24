package com.nishant0073.student_course_management_system.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nishant0073.student_course_management_system.Model.Course;
import com.nishant0073.student_course_management_system.Model.Instructor;
import com.nishant0073.student_course_management_system.Model.DTOs.CourseDTO;
import com.nishant0073.student_course_management_system.Model.DTOs.CourseRequestDTO;
import com.nishant0073.student_course_management_system.Repository.CourseRepository;
import com.nishant0073.student_course_management_system.Repository.InstructorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired 
    private InstructorRepository instructorRepository;

    public List<CourseDTO> GetCourses() {
        return courseRepository.findAll().stream().map(this::getCourseDTO).toList();
    }

    public CourseDTO AddCourse(CourseRequestDTO course) {
        Course newCourse = getNewCourse(course);
        Course createdCourse =  courseRepository.save(newCourse);
        CourseDTO courseDTO = getCourseDTO(createdCourse);
        return courseDTO;
    }



    public CourseDTO GetCourseById(Long id) {
        Course course  = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course is not prsent with id:" + id));

        CourseDTO courseDTO = getCourseDTO(course);
        return courseDTO;
    }
    public void DeleteCourse(Long id){
        if(!courseRepository.existsById(id)){
            throw new EntityNotFoundException("Course is not present with id:" + id);
        }
        courseRepository.deleteById(id);
    }

    public CourseDTO UpdateCourse(Long id,CourseRequestDTO  course) {

        Course createdCourse =  courseRepository.findById(id).map(crs -> {
        Instructor instructor = instructorRepository.findById(course.getinstructorId()).orElseThrow(() -> new  EntityNotFoundException("Instructor not found with id:"+course.getinstructorId()));
        crs.setTitle(course.getTitle());
        crs.setCredit(course.getCredit());
        crs.setInstructor(instructor);
            return courseRepository.save(crs);
        }).orElseThrow(() -> new EntityNotFoundException("Course not found with this id:" + id));

        CourseDTO courseDTO = getCourseDTO(createdCourse);
        return courseDTO;

    }

    private Course getNewCourse(CourseRequestDTO course) {

        Instructor instructor = instructorRepository.findById(course.getinstructorId()).orElseThrow(() -> new  EntityNotFoundException("Instructor not found with id:"+course.getinstructorId()));
        Course newCourse = new Course();
        newCourse.setTitle(course.getTitle());
        newCourse.setCredit(course.getCredit());
        newCourse.setInstructor(instructor);
        return newCourse;
    }
    private CourseDTO getCourseDTO(Course createdCourse) {
        CourseDTO courseDTO = new CourseDTO();  
        courseDTO.setId(createdCourse.getId());
        courseDTO.setTitle(createdCourse.getTitle());
        courseDTO.setCredit(createdCourse.getCredit());
        courseDTO.setInstructor(createdCourse.getInstructor());
        return courseDTO;
    }
}