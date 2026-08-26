package com.ltm.ecommerce.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import com.ltm.ecommerce.config.JwtService;
import com.ltm.ecommerce.dto.LoginRequest;
import com.ltm.ecommerce.dto.LoginResponse;
import com.ltm.ecommerce.dto.UserRequest;
import com.ltm.ecommerce.dto.UserResponse;
import com.ltm.ecommerce.entity.User;
import com.ltm.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager, JwtService jwtService) {

		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@Override
	public UserResponse registerUser(UserRequest request) {

		User user = new User();

		user.setUsername(request.getUsername());

		// Hash the password before saving
		user.setPassword(passwordEncoder.encode(request.getPassword()));

		// New registrations are USER by default
		user.setRole("USER");

		User savedUser = userRepository.save(user);

		UserResponse response = new UserResponse();

		response.setUserId(savedUser.getUserId());
		response.setUsername(savedUser.getUsername());
		response.setRole(savedUser.getRole());

		return response;
	}

	@Override
	public LoginResponse login(LoginRequest request) {

	    Authentication authentication =
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            request.getUsername(),
	                            request.getPassword()
	                    )
	            );

	    String role =
	            authentication.getAuthorities()
	                    .iterator()
	                    .next()
	                    .getAuthority();

	    String token =
	            jwtService.generateToken(
	                    request.getUsername(),
	                    role
	            );

	    return new LoginResponse(
	            "Login successful",
	            request.getUsername(),
	            token
	    );
	}

}