package com.zjkung.resumind.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zjkung.resumind.user.User;
import com.zjkung.resumind.user.UserDTO;
import com.zjkung.resumind.user.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserService userService;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;

  public void register(String email, String password, String fullName) {
    if (userService.existsByEmail(email))
      throw new RuntimeException("Email already registered.");
    userService.createUser(new UserDTO(email, passwordEncoder.encode(password), fullName));
  }

  public String login(String email, String password) {
    User user = userService.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("User not found"));
    if (!passwordEncoder.matches(password, user.getPasswordHash()))
      throw new RuntimeException("Invalid credentials");
    return jwtUtil.generateToken(email);
  }
}
