package com.smartJob.service;

import com.smartJob.dto.UserDTO;
import com.smartJob.dto.UserResponseDTO;
import com.smartJob.model.Phone;
import com.smartJob.model.Users;
import com.smartJob.repository.UserRepository;
import com.smartJob.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final JwtUtil jwtUtil;

    public UserResponseDTO registerUser(UserDTO userDTO){
        Users user = modelMapper.map(userDTO, Users.class);
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setActive(true);
        if(userDTO.getPhones()!= null){
            List<Phone> phones = userDTO.getPhones().stream()
                    .map(dto -> modelMapper.map(dto, Phone.class))
                    .collect(Collectors.toList());
            user.setPhones(phones);
        }
        String token = jwtUtil.generateToken(user.getEmail());
        user.setToken(token);
        Users newUser = userRepository.save(user);
        return modelMapper.map(newUser, UserResponseDTO.class);
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
