package com.example.LearningHub.mapper;

import com.example.LearningHub.dto.request.UserRequestDto;
import com.example.LearningHub.dto.response.StudentResponseDto;
import com.example.LearningHub.entity.Course;
import com.example.LearningHub.entity.HomeworkSubmission;
import com.example.LearningHub.entity.User;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;

public class StudentMapper {

    public static User toEntity(UserRequestDto dto){
        return User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .lastName(dto.getLastName())
                .name(dto.getName())
                .build();
    }

    public static Set<Long> mapEnrolledCourses(User user){
        return user.getEnrolledCourse()
                        .stream()
                        .map(Course::getId)
                        .collect(Collectors.toSet());
    }

    public static List<String> mapHomeworkSubmissions(User user){
        return user.getHomeworkSubmissions()
                .stream()
                .map(HomeworkSubmission::getFileUrl)
                .toList();
    }


    public static StudentResponseDto toDto(User user){
        return StudentResponseDto.builder()
                .email(user.getEmail())
                .lastName(user.getLastName())
                .name(user.getName())
                .createAt(user.getCreatedAt())
                .enrolledCourse(mapEnrolledCourses(user))
                .homeworkSubmissions(mapHomeworkSubmissions(user))
                .build();
    }
}
