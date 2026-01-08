package com.apispring.demo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
public class InformationUserResponse {
  private Long id;
  private String name;
  private String email;
  private boolean isActive;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
}
