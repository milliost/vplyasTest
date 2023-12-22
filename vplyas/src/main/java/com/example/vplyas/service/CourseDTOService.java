package com.example.vplyas.service;

import com.example.vplyas.entity.Course;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseDTOService {

    @NonNull Optional<Course> getCourseInfo(UUID id);

    void createCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(Course course);

    List<Course> getCourseCatalog();
}
