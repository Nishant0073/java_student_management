package com.nishant0073.student_course_management_system.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishant0073.student_course_management_system.Model.Office;
import com.nishant0073.student_course_management_system.Service.OfficeService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("office/")
public class OfficeController {
    
    @Autowired
    OfficeService officeService;

    @GetMapping("getAll")
    public ResponseEntity<?> GetOffices(){
        return ResponseEntity.ok(officeService.GetOffices());
    }

    @PostMapping("add")
    public ResponseEntity<?> AddOffice(@ModelAttribute Office office) {
        return ResponseEntity.ok(officeService.AddOffice(office));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> UpdateOffice(@PathVariable Long id, @RequestBody  Office entity) {
        return ResponseEntity.ok(officeService.UpdateOffice(id, entity));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> GetOfficeById(@PathVariable Long id){
        return ResponseEntity.ok(officeService.GetOfficeById(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> DeleteOfficeById(@PathVariable Long id){
        officeService.DeleteOffice(id);
        return ResponseEntity.noContent().build();
    }
    
}
