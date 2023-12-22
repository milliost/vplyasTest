package com.example.vplyas.repository;

import com.example.vplyas.entity.Course;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    @NonNull
    Optional<Course> findById(@NonNull UUID id);
}
