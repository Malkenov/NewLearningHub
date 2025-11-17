package com.example.LearningHub.entity;

import com.example.LearningHub.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import  java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Пользователи")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(name = "Пароль")
    private String password;

    @Column(name = "Имя")
    private String name;

    @Column(name = "Фамилия")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
    }


    @OneToMany(mappedBy = "teacher")
    private List<Course> createCourse;

    @ManyToMany(mappedBy = "students")
    private Set<Course> enrolledCourse;

    @OneToMany(mappedBy = "user")
    private List<HomeworkSubmission> homeworkSubmissions;

}
