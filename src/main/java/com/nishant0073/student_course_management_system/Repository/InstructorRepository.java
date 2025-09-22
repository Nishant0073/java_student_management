package com.nishant0073.student_course_management_system.Repository;
import org.springframework.stereotype.Repository;
import com.nishant0073.student_course_management_system.Model.Instructor;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

} 