package com.example.vplyas.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;
import java.sql.Time;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonProperty("course_id")
    private UUID courseId; //не course_id потому что JPA не любит '_'

    @Column(nullable = false, unique = true)
    private String title;

    private String description;

    private Time duration;

    @Column(nullable = false, unique = true)
    private int order_; //order Зарезервированное слово

    private URL video_url;
}
