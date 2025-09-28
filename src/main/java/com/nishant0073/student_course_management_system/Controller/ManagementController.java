package com.nishant0073.student_course_management_system.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishant0073.student_course_management_system.Service.ManagementService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("manage/")
public class ManagementController {

    @Autowired
    private  ManagementService managementService;

    @PutMapping("enroll/student/{studentId}/course/{courseId}")
    public ResponseEntity<?> enrollCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {

        return ResponseEntity.ok(managementService.enrollStudentInCourse(studentId, courseId));
    }

    @PutMapping("enroll/course/{courseId}/instructor/{instructorId}")
    public ResponseEntity<?> enrollInstructorToCourse(@PathVariable Long courseId, @PathVariable Long instructorId) {

        return ResponseEntity.ok(managementService.enrollCourseToInstructor(courseId, instructorId));
    }
    
}
