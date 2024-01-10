package com.example.vplyas.repository;

import com.example.vplyas.entity.Course;
import com.example.vplyas.entity.Lesson;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {
    @NonNull
    Optional<Lesson> findById(@NonNull UUID id);
    List<Lesson> findAllByCourseId(UUID id);
}

