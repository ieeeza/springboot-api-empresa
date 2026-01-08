package com.apispring.demo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ListAllUsersResponse {
  private List<InformationUserResponse> users;
}
