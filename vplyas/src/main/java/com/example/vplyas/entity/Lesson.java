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
@Table(name="lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    @Column(nullable = false,unique = true)
    private String title;

    private String description;

    private int duration;

    @Column(nullable = false,unique = true)
    private int order_; //order Зарезервированное слово

    private String videoUrl;
}
