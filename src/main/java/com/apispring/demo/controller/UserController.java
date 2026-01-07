package com.apispring.demo.controller;

import com.apispring.demo.dtos.request.LoginUserRequest;
import com.apispring.demo.dtos.response.CreateUserResponse;
import com.apispring.demo.dtos.response.LoginUserResponse;
import com.apispring.demo.dtos.response.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apispring.demo.domain.entity.User;
import com.apispring.demo.dtos.request.CreateUserRequest;
import com.apispring.demo.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/login")
  public ResponseEntity<ServiceResponse<LoginUserResponse>> login(@RequestBody LoginUserRequest loginUserRequest) {
    return ResponseEntity.status(HttpStatus.OK).body(
            userService.login(loginUserRequest)
    );
  }

  @PostMapping("/create")
  public ResponseEntity<ServiceResponse<CreateUserResponse>> createUser(@RequestBody CreateUserRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
      .body(
        userService.createUser(
          User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .passwordHash(request.getPassword())
            .build()
        )
      );
  }
}
