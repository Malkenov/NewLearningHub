package com.example.LearningHub.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthenticationDto {

    @Email(message = "Email обязательно!")
    private String email;

    @NotBlank(message = "Пароль обязательно")
    @Size(min = 5,max = 20,message = "Пароль должен быть минимум 5 символов,максимум 20 символов")
    private String password;
}
