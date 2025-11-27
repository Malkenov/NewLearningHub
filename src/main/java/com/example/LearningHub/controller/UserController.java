package com.example.LearningHub.controller;


import com.example.LearningHub.dto.request.UserAuthenticationDto;
import com.example.LearningHub.dto.request.UserRequestDto;
import com.example.LearningHub.dto.response.StudentResponseDto;
import com.example.LearningHub.dto.response.TeacherResponseDto;
import com.example.LearningHub.dto.response.UserAuthenticationResponse;
import com.example.LearningHub.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/{create/student}")
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody @Validated UserRequestDto dto){
        return ResponseEntity.ok(userService.createStudent(dto));
    }

    @PostMapping("/{create/teacher}")
    public ResponseEntity<TeacherResponseDto> createTeacher(@RequestBody @Validated UserRequestDto dto){
        return ResponseEntity.ok(userService.createTeacher(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticationResponse> login(@RequestBody @Validated UserAuthenticationDto dto){
        return ResponseEntity.ok(userService.login(dto));
    }
}
