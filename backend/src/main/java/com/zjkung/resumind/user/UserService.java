package com.zjkung.resumind.user;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public List<User> getUser() {
    return userRepository.findAll();
  }
}
