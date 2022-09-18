package com.develowick.semaine1.service.impl;

import com.develowick.semaine1.model.Course;
import com.develowick.semaine1.repository.CourseRepository;
import com.develowick.semaine1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    @Override
    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }
}
