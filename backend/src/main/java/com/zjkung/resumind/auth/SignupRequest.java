package com.zjkung.resumind.auth;

public record SignupRequest(String email, String password, String fullName) {
}
