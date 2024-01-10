package com.example.vplyas.controllers;

import com.example.vplyas.entity.Lesson;
import com.example.vplyas.service.LessonDTOService;
import com.example.vplyas.service.impl.LessonDTOServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RestController
public class LessonController {

    LessonDTOService lessonDTOService;
    private static final Logger logger = LoggerFactory.getLogger(LessonController.class);


    @PostMapping("/course/{courseUUID}/lesson")
    public UUID createLesson(@PathVariable("courseUUID") UUID courseUUID,
                             @ModelAttribute Lesson lesson) {
        logger.info(lesson.getVideo_url().toString());
        return lessonDTOService.createLesson(courseUUID, lesson);
    }

    @PatchMapping("/course/lesson/{lessonUUID}")
    public void updateLesson(@PathVariable UUID lessonUUID, @ModelAttribute Lesson lesson) {
        lessonDTOService.updateLesson(lessonUUID, lesson);
    }

    @DeleteMapping("/course/lesson/{lessonUUID}")
    public void deleteCourse(@PathVariable("lessonUUID") UUID lessonUUID) {
        lessonDTOService.deleteLesson(lessonUUID);
    }

    @GetMapping("/lessons/{course_id}")
    public List<Lesson> getCourseLessons(@PathVariable("course_id") UUID course_id) {
        return lessonDTOService.getCourseLessons(course_id);
    }


}
