package com.smartJob.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotEmpty(message = "El nombre es obligatorio")
    private String name;

    @NotEmpty(message = "El correo es obligatorio")
    @Pattern(message = "El correo no es correcto",
    flags = Pattern.Flag.CASE_INSENSITIVE,
    regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

    @NotEmpty(message = "La contraseña es obligatoria")
    @Pattern(message = "Al menos 8 caracteres, al menos una letra y un número",
    regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;

    private List<PhoneDTO> phones;

    public List<PhoneDTO> getPhones() {
        return phones;
    }
}
