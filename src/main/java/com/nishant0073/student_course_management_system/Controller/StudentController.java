package com.nishant0073.student_course_management_system.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishant0073.student_course_management_system.Model.DTOs.StudentRequestDTO;
import com.nishant0073.student_course_management_system.Service.StudentService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("students/")
public class StudentController {
    
    @Autowired
    StudentService studentService;

    @GetMapping("getAll")
    public ResponseEntity<?> GetStudents(){
        return ResponseEntity.ok(studentService.GetStudents());
    }

    @PostMapping("add")
    public ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO student) {
        return ResponseEntity.ok(studentService.AddStudent(student));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> UpdateCustomer(@PathVariable Long id, @RequestBody  StudentRequestDTO entity) {
        return ResponseEntity.ok(studentService.UpdateStudent(id,entity));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> GetStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.GetStudentById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> DeleteStudentById(@PathVariable Long id){
        studentService.DeleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    
}
