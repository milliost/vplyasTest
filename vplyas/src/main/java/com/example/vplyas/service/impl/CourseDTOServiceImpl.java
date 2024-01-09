package com.example.vplyas.service.impl;

import com.example.vplyas.config.errors.ResourceNotFoundException;
import com.example.vplyas.entity.Course;
import com.example.vplyas.repository.CourseRepository;
import com.example.vplyas.service.CourseDTOService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CourseDTOServiceImpl implements CourseDTOService {

    CourseRepository courseRepository;
    private static final Logger logger = LoggerFactory.getLogger(CourseDTOServiceImpl.class);
    @Override
    public Course getCourseInfo(UUID id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course with id " + id + " not found"));
    }

    @Override
    public UUID createCourse(Course course) {
        courseRepository.save(course);
        return course.getId();
    }

    @Override
    public void updateCourse(UUID id,Course updatedCourse) {
        Course courseToBeUpdated = getCourseInfo(id);

        courseToBeUpdated.setUser(updatedCourse.getUser());
        courseToBeUpdated.setStatus(updatedCourse.getStatus());
        logger.info(updatedCourse.getStatus().toString());
        courseToBeUpdated.setTitle(updatedCourse.getTitle());
        courseToBeUpdated.setDescription(updatedCourse.getDescription());
        courseToBeUpdated.setStyle(updatedCourse.getStyle());

        courseToBeUpdated.setLessons_number(updatedCourse.getLessons_number());
        courseToBeUpdated.setAverage_lessons_duration(updatedCourse.getAverage_lessons_duration());

        courseToBeUpdated.setCover_image_url(updatedCourse.getCover_image_url());
        courseToBeUpdated.setPreview_video_url(updatedCourse.getPreview_video_url());
        courseToBeUpdated.setPrice(updatedCourse.getPrice());
        courseRepository.save(courseToBeUpdated);

    }

    @Override
    public void deleteCourse(UUID uuid) {
        courseRepository.delete(getCourseInfo(uuid));
    }

    @Override
    public List<Course> getCourseCatalog() {
        return courseRepository.findAll();
    }
}
