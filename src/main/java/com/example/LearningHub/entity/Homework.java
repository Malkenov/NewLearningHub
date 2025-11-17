package com.example.LearningHub.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Домашняя задание")
@Builder
public class Homework {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Название")
    private String title;

    @Column(name = "Описание")
    private String descriptions;

    @Column(name = "Время окончание")
    private LocalDate deadline;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @OneToMany(mappedBy = "homework")
    private List<HomeworkSubmission> homeworkSubmission;
}
