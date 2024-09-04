package com.smartJob.controller;

import com.smartJob.dto.ErrorDTO;
import com.smartJob.dto.UserDTO;
import com.smartJob.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registeruser(@Valid @RequestBody UserDTO userDTO) {
        if (userService.emailExists(userDTO.getEmail())) {
            return ResponseEntity.badRequest().body(ErrorDTO.builder().message("El correo ya registrado").build());
        }
        return new ResponseEntity<>(userService.registerUser(userDTO), HttpStatus.CREATED);
    }
}

