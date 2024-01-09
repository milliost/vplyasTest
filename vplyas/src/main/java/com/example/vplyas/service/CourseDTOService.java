package com.example.vplyas.service;

import com.example.vplyas.entity.Course;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseDTOService {

    Course getCourseInfo(UUID id);

    UUID createCourse(Course course);

    void updateCourse(UUID id, Course updatedCourse);

    void deleteCourse(UUID uuid);

    List<Course> getCourseCatalog();
}
