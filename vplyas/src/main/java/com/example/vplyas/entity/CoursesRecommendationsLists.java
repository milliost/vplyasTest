package com.example.vplyas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses_RecommendationsLists")
public class CoursesRecommendationsLists {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "recommendationsLists_id")
    RecommendationsLists recommendationsLists;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;
}
