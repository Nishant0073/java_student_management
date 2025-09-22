package com.nishant0073.student_course_management_system.Repository;
import org.springframework.stereotype.Repository;

import com.nishant0073.student_course_management_system.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

} 