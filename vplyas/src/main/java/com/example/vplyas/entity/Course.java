package com.example.vplyas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User user;

    private Date created_at;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Course_statuses status;

    @Column(nullable = false, unique = true)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Style style;

    @Column(nullable = false)
    private int lessons_number;

    @Column(nullable = false)
    private int average_lessons_duration;


    private String cover_image_url;

    private String preview_video_url;

    private int price;

    public enum Course_statuses {
        DRAFT,
        PUBLISHED,
        ANNOUNCEMENT,
        NOT_VISIBLE
    }

    public enum Style {
        HIP_HOP,
        VOGUE,
        TANGO
    }

}
