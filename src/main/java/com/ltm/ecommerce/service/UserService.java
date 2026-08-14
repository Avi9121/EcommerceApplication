package com.ltm.ecommerce.service;

import com.ltm.ecommerce.dto.UserRequest;
import com.ltm.ecommerce.dto.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest request);

}