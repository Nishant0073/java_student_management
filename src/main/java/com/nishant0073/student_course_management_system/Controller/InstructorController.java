package com.nishant0073.student_course_management_system.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishant0073.student_course_management_system.Model.Instructor;
import com.nishant0073.student_course_management_system.Service.InstructorService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("instructor/")
public class InstructorController {
    
    @Autowired
    InstructorService instrcutorService;

    @GetMapping("getAll")
    public ResponseEntity<?> GetInstructors(){
        return ResponseEntity.ok(instrcutorService.GetInstructors());
    }

    @PostMapping("add")
    public ResponseEntity<?> addInstructor(@ModelAttribute Instructor instructor) {
        return ResponseEntity.ok(instrcutorService.AddInstructor(instructor));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> UpdateInstructor(@PathVariable Long id, @RequestBody  Instructor entity) {
        return ResponseEntity.ok(instrcutorService.UpdateInstructor(id, entity));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> GetInstructorById(@PathVariable Long id){
        return ResponseEntity.ok(instrcutorService.GetInstructorById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> DeleteInstructortById(@PathVariable Long id){
        instrcutorService.DeleteInstructor(id);
        return ResponseEntity.noContent().build();
    }
    
}
