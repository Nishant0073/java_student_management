package com.nishant0073.student_course_management_system.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishant0073.student_course_management_system.Model.Course;
import com.nishant0073.student_course_management_system.Service.CourseService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("course/")
public class CourseController {
    
    @Autowired
    CourseService courseService;

    @GetMapping("getAll")
    public ResponseEntity<?> GetCourses(){
        return ResponseEntity.ok(courseService.GetCourses());
    }

    @PostMapping("add")
    public ResponseEntity<?> AddCourse(@ModelAttribute Course course) {
        return ResponseEntity.ok(courseService.AddCourse(course));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> UpdateCourse(@PathVariable Long id, @RequestBody  Course entity) {
        return ResponseEntity.ok(courseService.UpdateCourse(id, entity));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> GetCourseById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.GetCourseById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> DeleteCourseById(@PathVariable Long id){
        courseService.DeleteCourse(id);
        return ResponseEntity.noContent().build();
    }
    
}
