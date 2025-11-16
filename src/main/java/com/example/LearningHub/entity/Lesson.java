package com.example.LearningHub.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Уроки")
@Builder
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Название")
    private String title;

    @Column(name = "Описание")
    private String content;

    @Column(name = "Номер урока")
    private Long position;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne(mappedBy = "lesson",cascade = CascadeType.ALL)
    private Homework homework;

}
