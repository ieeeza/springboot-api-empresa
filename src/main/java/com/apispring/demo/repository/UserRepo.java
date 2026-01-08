package com.apispring.demo.repository;

import com.apispring.demo.domain.entity.User;
import com.apispring.demo.domain.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

  boolean existsByEmail(String email);

  List<User> findByRole(UserRole role);

  List<User> findByIsActiveTrue();

  List<User> findByRoleAndIsActiveTrue(UserRole role);

  List<User> findAll();
}
