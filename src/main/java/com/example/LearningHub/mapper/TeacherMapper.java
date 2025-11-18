package com.example.LearningHub.mapper;

import com.example.LearningHub.dto.request.UserRequestDto;
import com.example.LearningHub.dto.response.TeacherResponseDto;
import com.example.LearningHub.entity.Course;
import com.example.LearningHub.entity.User;

import java.util.List;

public class TeacherMapper {

    public static User toEntity(UserRequestDto dto){
            return User.builder()
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .lastName(dto.getLastName())
                    .name(dto.getName())
                    .build();
    }

    public static List<String> mapCreateCourse(User user){
        return user.getCreateCourse()
                .stream()
                .map(Course::getTitle)
                .toList();
    }

     public static TeacherResponseDto toDto(User user){
        return TeacherResponseDto.builder()
                .email(user.getEmail())
                .lastName(user.getLastName())
                .name(user.getName())
                .createAt(user.getCreatedAt())
                .createCourse(mapCreateCourse())
                .build();
     }
}
