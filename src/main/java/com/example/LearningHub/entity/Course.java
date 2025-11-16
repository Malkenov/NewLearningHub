package com.example.LearningHub.entity;


import com.example.LearningHub.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Курсы")
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Название")
    private String title;

    @Column(name = "Описание")
    private String descriptions;

    @Column(name = "Время создания")
    private LocalDateTime createdAd;

    @Enumerated(EnumType.STRING)
    private Status status;



    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<User> students = new HashSet<>();


    @OneToMany(mappedBy = "course")
    private List<Lesson> lessonList;

    @OneToMany(mappedBy = "course")
    private List<Homework> homeworkList;

}
