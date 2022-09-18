package com.develowick.semaine1.service;

import com.develowick.semaine1.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses(String topicId);
    Course getCourse(String id);

    void addCourse(Course course);
}
