package com.nishant0073.student_course_management_system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nishant0073.student_course_management_system.Model.UserAuthEntity;
import com.nishant0073.student_course_management_system.Service.UserAuthEntityService;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired 
    private UserAuthEntityService userAuthEntityService;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserAuthEntity userAuthEntity){
        userAuthEntity.setPassword(passwordEncoder.encode(userAuthEntity.getPassword()));
        userAuthEntityService.registerUser(userAuthEntity);
        return ResponseEntity.ok("User added successfully!");
    }
    
}
