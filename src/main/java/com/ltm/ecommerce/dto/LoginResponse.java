package com.ltm.ecommerce.dto;

public class LoginResponse {

    private String message;
    private String username;
    private String token;

    public LoginResponse(String message, String username,String token) {
        this.message = message;
        this.username = username;
        this.token=token;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
		return token;
	}


	public String getUsername() {
        return username;
    }
}