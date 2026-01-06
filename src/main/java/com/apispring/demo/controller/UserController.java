package com.apispring.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apispring.demo.domain.entity.User;
import com.apispring.demo.dtos.request.CreateUserRequest;
import com.apispring.demo.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("create")
  public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
      
    User user = User.builder()
        .name(request.getName())
        .email(request.getEmail())
        .passwordHash(request.getPassword())
        .build();

    User entity = userService.createUser(user);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(entity);
  }
  
}
