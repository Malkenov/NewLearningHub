package com.example.LearningHub.service;


import com.example.LearningHub.dto.request.UserRequestDto;
import com.example.LearningHub.dto.response.StudentResponseDto;
import com.example.LearningHub.entity.User;
import com.example.LearningHub.exception.NotFoundException;
import com.example.LearningHub.mapper.StudentMapper;
import com.example.LearningHub.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentResponseDto postStudent(UserRequestDto dto){
        userRepository.findByEmail(dto.getEmail())
                .orElseThrow(()-> new NotFoundException("Пользователь с email " + dto.getEmail() + "существует!"));

        User user = StudentMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return StudentMapper.toDto(user);

    }
}
