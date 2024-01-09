package com.example.vplyas.service.impl;

import com.example.vplyas.config.errors.ResourceNotFoundException;
import com.example.vplyas.entity.Course;
import com.example.vplyas.repository.CourseRepository;
import com.example.vplyas.service.CourseDTOService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CourseDTOServiceImpl implements CourseDTOService {

    CourseRepository courseRepository;
    @Override
    public Course getCourseInfo(UUID id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course with id " + id + " not found"));
    }

    @Override
    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(UUID id,Course updatedCourse) {
        Course courseToBeUpdated = getCourseInfo(id);

        courseToBeUpdated.setUser(updatedCourse.getUser());
        courseToBeUpdated.setStatus(updatedCourse.getStatus());
        courseToBeUpdated.setTitle(updatedCourse.getTitle());
        courseToBeUpdated.setDescription(updatedCourse.getDescription());
        courseToBeUpdated.setStyle(updatedCourse.getStyle());

        courseToBeUpdated.setLessons_number(updatedCourse.getLessons_number());
        courseToBeUpdated.setAverage_lessons_duration(updatedCourse.getAverage_lessons_duration());

        courseToBeUpdated.setCover_image_url(updatedCourse.getCover_image_url());
        courseToBeUpdated.setPreview_video_url(updatedCourse.getPreview_video_url());
        courseToBeUpdated.setPrice(updatedCourse.getPrice());

    }

    @Override
    public void deleteCourse(Course course) {

    }

    @Override
    public List<Course> getCourseCatalog() {
        return courseRepository.findAll();
    }
}
