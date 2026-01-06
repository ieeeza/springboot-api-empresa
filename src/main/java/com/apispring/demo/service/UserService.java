package com.apispring.demo.service;

import org.springframework.stereotype.Service;

import com.apispring.demo.domain.entity.User;
import com.apispring.demo.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  
  private final UserRepo userRepo;

  public User createUser(User user) {
    if (userRepo.existsByEmail(user.getEmail())) {
      throw new IllegalArgumentException("Email already in use");
    }

    user.setIsActive(true);
    return userRepo.save(user);
  }
}
