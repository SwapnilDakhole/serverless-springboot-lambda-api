package org.example.service;

import org.example.dto.Course;
import org.example.repositiory.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public void addCourse(Course course) {
        courseRepository.save(course);
    }


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }


    public boolean updateCourse(Long id, Course newCourse) {
        return getCourseById(id).map(existingCourse -> {

            existingCourse.setName(newCourse.getName());
            existingCourse.setPrice(newCourse.getPrice());
            courseRepository.save(existingCourse);
            return true;
        }).orElse(false);
    }


    public boolean deleteCourse(Long id) {
        return getCourseById(id).map(course -> {
            courseRepository.delete(course);
            return true;
        }).orElse(false);
    }
}
