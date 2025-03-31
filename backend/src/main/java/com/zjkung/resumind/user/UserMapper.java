package com.zjkung.resumind.user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserMapper {
  public User toEntity(UserDTO userDTO) {
    User user = new User();
    user.setEmail(userDTO.email());
    user.setFullName(userDTO.fullName());
    user.setPasswordHash(userDTO.password());
    return user;
  }
}
