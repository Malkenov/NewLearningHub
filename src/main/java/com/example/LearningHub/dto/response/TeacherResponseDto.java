package com.example.LearningHub.dto.response;


import com.example.LearningHub.entity.Course;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherResponseDto {

    private String email;
    private String lastName;
    private String name;
    private LocalDateTime createAt;

    private List<Course> createCourse;
}
