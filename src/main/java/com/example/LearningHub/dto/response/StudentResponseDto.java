package com.example.LearningHub.dto.response;

import com.example.LearningHub.entity.Course;
import com.example.LearningHub.entity.HomeworkSubmission;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponseDto {

    private String email;
    private String lastName;
    private String name;
    private LocalDateTime createAt;

    private Set<Long> enrolledCourse;
    private List<String> homeworkSubmissions;
}
