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

    @GetMapping("/course/{id}")
    public Course getCourseInfo(@PathVariable("id") UUID uuid) {
        return courseDTOService.getCourseInfo(uuid);
    }

    @GetMapping("/courses")
    public List<Course> getCourseCatalog() {
        return courseDTOService.getCourseCatalog();
    }

    @PatchMapping("/course/{id}")
    public void UpdateCourse(@PathVariable UUID id, @ModelAttribute Course course) {
        courseDTOService.updateCourse(id, course);
    }

    @PostMapping("/course")
    public UUID CreateCourse(@ModelAttribute Course course) {
        return courseDTOService.createCourse(course);
    }

}
