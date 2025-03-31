package com.zjkung.resumind.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping()
  public ResponseEntity<List<User>> getUser() {
    return ResponseEntity.ok(userService.getUser());
  }
}
