package com.example.LearningHub.entity;


import com.example.LearningHub.enums.HomeworkStatus;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Проверка задания")
@Builder
public class HomeworkSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Текстовый ответ")
    private String textAnswer;

    @Column
    private String fileUrl;

    @Enumerated(EnumType.STRING)
    private HomeworkStatus status;

    @Column(name = "Класс")
    private String grade;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "homework_id")
    private Homework homework;
}
