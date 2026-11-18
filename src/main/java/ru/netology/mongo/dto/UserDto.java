package ru.netology.mongo.dto;

import jakarta.validation.constraints.*;

public record UserDto(

        String id,
        @NotBlank(message = "имя не может быть пустым")
        @Size(max = 50, message = "имя не должно превышать 50 символов")
        String name,

        @NotBlank(message = "не может быть пустым")
        @Size(max = 100, message = "емаил не должен превышать 100 символов")
        @Email(message = "Некорректный email")
        String email,

        @NotNull(message = "Возраст не может быть пустым")
        @Min(value = 1, message = "Возраст не может быть меньше 1")
        @Max(value = 199, message = "Возраст не может быть больше 199")
        Integer age) {
}
