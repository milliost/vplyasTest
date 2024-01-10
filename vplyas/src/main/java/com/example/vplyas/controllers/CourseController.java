package com.example.vplyas.controllers;

import com.example.vplyas.entity.Course;
import com.example.vplyas.service.CourseDTOService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class CourseController {

    CourseDTOService courseDTOService;

    @PostMapping("/course")
    public UUID createCourse(@ModelAttribute Course course) {
        return courseDTOService.createCourse(course);
    }

    @GetMapping("/course/{uuid}")
    public Course getCourseInfo(@PathVariable("uuid") UUID uuid) {
        return courseDTOService.getCourseInfo(uuid);
    }

    @GetMapping("/courses")
    public List<Course> getCourseCatalog() {
        return courseDTOService.getCourseCatalog();
    }

    @PatchMapping("/course/{id}")
    public void updateCourse(@PathVariable UUID id, @ModelAttribute Course course) {
        courseDTOService.updateCourse(id, course);
    }

    @DeleteMapping("/course/{uuid}")
    public void deleteCourse(@PathVariable("uuid") UUID uuid) {
        courseDTOService.deleteCourse(uuid);
    }

}
