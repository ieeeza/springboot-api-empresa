package com.apispring.demo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class CreateUserResponse {
  private String name;
  private String email; 
}
