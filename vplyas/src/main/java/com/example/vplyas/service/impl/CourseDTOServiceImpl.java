package com.example.vplyas.service.impl;

import com.example.vplyas.entity.Course;
import com.example.vplyas.repository.CourseRepository;
import com.example.vplyas.service.CourseDTOService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CourseDTOServiceImpl implements CourseDTOService {

    CourseRepository courseRepository;
    @Override
    public @NonNull Optional<Course> getCourseInfo(UUID id) {
        return courseRepository.findById(id);
    }

    @Override
    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {

    }

    @Override
    public void deleteCourse(Course course) {

    }

    @Override
    public List<Course> getCourseCatalog() {
        return courseRepository.findAll();
    }
}
