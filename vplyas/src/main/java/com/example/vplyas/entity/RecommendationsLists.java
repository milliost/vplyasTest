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
@Table(name="recommendations_lists")
public class RecommendationsLists {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,unique = true)
    private String title;

    @Column(nullable = false)
    private Course.Course_statuses courseStatuses;

    @Column(unique = true)
    private String description;

    @Column(unique = true)//почему оно уникальное ?
    private int coursesCount;


    @Column(unique = true)
    private String coverImage;
}
