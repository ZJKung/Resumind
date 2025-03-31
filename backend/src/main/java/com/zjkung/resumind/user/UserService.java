package com.zjkung.resumind.user;

import java.util.List;
import java.util.Optional;

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

  public Long createUser(UserDTO userDTO) {
    User user = userMapper.toEntity(userDTO);
    return userRepository.save(user).getId();
  }

  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

  public void updateUser(Long id, UserDTO userDTO) {
    User user = userMapper.toEntity(userDTO);
    user.setId(id);
    userRepository.save(user);
  }

  public boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  public boolean existsById(Long id) {
    return userRepository.existsById(id);
  }
}
