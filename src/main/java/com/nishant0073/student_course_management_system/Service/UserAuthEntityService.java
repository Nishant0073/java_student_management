package com.nishant0073.student_course_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nishant0073.student_course_management_system.Model.UserAuthEntity;
import com.nishant0073.student_course_management_system.Repository.UserAuthEntityRepository;


@Service
public class UserAuthEntityService implements UserDetailsService {

    @Autowired
    private UserAuthEntityRepository userAuthEntityRepository;
    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthEntityRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
    }

    public UserDetails  registerUser(UserAuthEntity userAuthEntity){
        return userAuthEntityRepository.save(userAuthEntity);
    }

    
}