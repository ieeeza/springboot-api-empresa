package com.apispring.demo.domain.entity;

import java.time.OffsetDateTime;

import com.apispring.demo.domain.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 120)
  private String name;

  @Column(nullable = false, length = 150)
  private String email;

  @Column(name = "password_hash", nullable = false, length = 255)
  private String passwordHash;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  @Builder.Default
  private UserRole role = UserRole.COMMON_USER;

  @Column(length = 255)
  private String token;

  @Column(name = "token_expire_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private OffsetDateTime tokenExpireAt;

  @Column(name = "is_active", nullable = false)
  @Builder.Default
  private Boolean isActive = true;

  @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private OffsetDateTime createdAt;

  @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private OffsetDateTime updatedAt;

  @Column(name = "last_verified_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private OffsetDateTime lastVerifiedAt;

  @PrePersist
  protected void onCreate() {
    this.createdAt = OffsetDateTime.now();
    this.isActive = true;
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = OffsetDateTime.now();
  }
}