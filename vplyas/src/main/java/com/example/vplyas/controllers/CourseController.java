package com.example.vplyas.controllers;

import com.example.vplyas.entity.Course;
import com.example.vplyas.service.CourseDTOService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Controller()
public class CourseController{

    CourseDTOService courseDTOService;

    @GetMapping("/course/{code}")
    @ResponseBody
    public @NonNull Optional<Course> getCourseInfo(@PathVariable("code") String id){

        return courseDTOService.getCourseInfo(UUID.fromString(id));
    }

    @ResponseBody
    @GetMapping("/courses")
    public @NonNull List<Course> getCourseCatalog(){
        return courseDTOService.getCourseCatalog();
    }



}
