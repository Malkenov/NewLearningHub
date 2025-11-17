package com.example.LearningHub.dto.request;

import com.example.LearningHub.entity.Course;
import com.example.LearningHub.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @Email(message = "Емайл не должен быть пустым!")
    private String email;

    @NotBlank(message = "Пароль не должен быть пустым")
    @Size(min = 6,max = 20,message = "Пароль должен содержать от 6 до 20 символов!")
    private String password;

    @NotBlank(message = "Имя обязательно!")
    private String name;

    @NotBlank(message = "Фамилия обязательно!")
    private String lastName;

}
