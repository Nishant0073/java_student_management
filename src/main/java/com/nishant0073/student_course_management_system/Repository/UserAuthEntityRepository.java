package com.nishant0073.student_course_management_system.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nishant0073.student_course_management_system.Model.UserAuthEntity;

@Repository
public interface UserAuthEntityRepository extends JpaRepository<UserAuthEntity,Long> {
    Optional<UserAuthEntity> findByUsername(String username);
}