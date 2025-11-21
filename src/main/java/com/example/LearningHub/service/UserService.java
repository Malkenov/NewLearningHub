package com.example.LearningHub.service;


import com.example.LearningHub.dto.request.UserRequestDto;
import com.example.LearningHub.dto.response.StudentResponseDto;
import com.example.LearningHub.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public StudentResponseDto postStudent(UserRequestDto dto){

    }
}
