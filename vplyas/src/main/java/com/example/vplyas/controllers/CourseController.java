package com.example.vplyas.controllers;

import com.example.vplyas.entity.Course;
import com.example.vplyas.service.CourseDTOService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class CourseController{

    CourseDTOService courseDTOService;

    @GetMapping("/course/{id}")
    public Course getCourseInfo(@PathVariable("id") UUID uuid){
        return courseDTOService.getCourseInfo(uuid);
    }

    @GetMapping("/courses")
    public List<Course> getCourseCatalog(){
        return courseDTOService.getCourseCatalog();
    }
    @PatchMapping("/course/{id}")
    public void UpdateCourse(@PathVariable UUID id, @RequestParam Course course) {
        courseDTOService.updateCourse(id,course);
    }


}
