package com.example.LearningHub.service;


import com.example.LearningHub.dto.request.UserAuthenticationDto;
import com.example.LearningHub.dto.request.UserRequestDto;
import com.example.LearningHub.dto.response.StudentResponseDto;
import com.example.LearningHub.dto.response.TeacherResponseDto;
import com.example.LearningHub.dto.response.UserAuthenticationResponse;
import com.example.LearningHub.entity.User;
import com.example.LearningHub.exception.BadRequestException;
import com.example.LearningHub.exception.NotFoundException;
import com.example.LearningHub.mapper.StudentMapper;
import com.example.LearningHub.mapper.TeacherMapper;
import com.example.LearningHub.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public StudentResponseDto createStudent(UserRequestDto dto){
        userRepository.findByEmail(dto.getEmail())
                .orElseThrow(()-> new NotFoundException("Студент с email " + dto.getEmail() + "существует!"));

        User user = StudentMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return StudentMapper.toDto(user);
    }

    public TeacherResponseDto createTeacher(UserRequestDto dto){
        userRepository.findByEmail(dto.getEmail())
                .orElseThrow(()-> new NotFoundException("Преподаватель с email " + dto.getEmail() + "существует!"));
        User user = TeacherMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return TeacherMapper.toDto(user);
    }

    public UserAuthenticationResponse login(UserAuthenticationDto dto){
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(()-> new NotFoundException("Пользователь с " + dto.getEmail() + "не найден!"));
        if(!passwordEncoder.matches(user.getPassword(), dto.getPassword())){
            throw new BadRequestException("Неверный пароль!");
        }
        return new UserAuthenticationResponse(dto.getEmail());
    }

}
