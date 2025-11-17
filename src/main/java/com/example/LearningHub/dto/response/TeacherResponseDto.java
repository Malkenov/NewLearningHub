package com.example.LearningHub.dto.response;


import com.example.LearningHub.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponseDto {

    private String email;
    private String lastName;
    private String name;
    private LocalDateTime createAt;

    private List<Course> createCourse;
}
