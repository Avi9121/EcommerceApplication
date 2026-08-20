package com.ltm.ecommerce.service;

import com.ltm.ecommerce.dto.LoginRequest;
import com.ltm.ecommerce.dto.LoginResponse;
import com.ltm.ecommerce.dto.UserRequest;
import com.ltm.ecommerce.dto.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest request);
    LoginResponse login(LoginRequest request);
 }
