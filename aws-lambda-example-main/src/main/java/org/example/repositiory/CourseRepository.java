package org.example.repositiory;

import org.example.dto.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long>{
}
