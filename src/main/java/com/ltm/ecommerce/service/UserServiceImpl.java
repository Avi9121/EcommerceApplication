package com.ltm.ecommerce.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ltm.ecommerce.dto.UserRequest;
import com.ltm.ecommerce.dto.UserResponse;
import com.ltm.ecommerce.entity.User;
import com.ltm.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse registerUser(UserRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());

        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(request.getRole());

        User savedUser = userRepository.save(user);

        UserResponse response = new UserResponse();

        response.setUserId(savedUser.getUserId());
        response.setUsername(savedUser.getUsername());
        response.setRole(savedUser.getRole());

        return response;
    }
}