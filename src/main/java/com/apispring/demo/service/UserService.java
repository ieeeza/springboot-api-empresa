package com.apispring.demo.service;

import com.apispring.demo.domain.entity.User;
import com.apispring.demo.dtos.request.LoginUserRequest;
import com.apispring.demo.dtos.response.*;
import com.apispring.demo.exceptions.Fields.FieldEmailRequiredException;
import com.apispring.demo.exceptions.Fields.FieldPasswordRequiredException;
import com.apispring.demo.exceptions.User.UserAlreadyExistException;
import com.apispring.demo.exceptions.User.UserDoNotExistException;
import com.apispring.demo.integration.email.EmailService;
import com.apispring.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

  private final UserRepo userRepo;
  private final EmailService emailService;

  public ServiceResponse<CreateUserResponse> createUser(User user) {
    if (user.getEmail() == null || user.getEmail().isEmpty() || user.getEmail().isBlank())
      throw new FieldEmailRequiredException();

    if (userRepo.existsByEmail(user.getEmail()))
      throw new UserAlreadyExistException();

    User savedUser = userRepo.save(user);

    emailService.sendEmail(
        savedUser.getEmail(),
        "Bem-vindo ao nosso sistema!",
        "<h1>Bem-vindo</h1><p>Conta criada com sucesso</p>"
    );

    return ServiceResponse.success(
        new CreateUserResponse(
            savedUser.getEmail(),
            savedUser.getName()
        ),
        "Usuário cadastrado com sucesso",
        201
    );
  }

  public ServiceResponse<LoginUserResponse> login(LoginUserRequest loginUserRequest) {
    if (loginUserRequest.getEmail() == null || loginUserRequest.getEmail().isEmpty() || loginUserRequest.getEmail().isBlank())
      throw new FieldEmailRequiredException();

    if (loginUserRequest.getPassword() == null || loginUserRequest.getPassword().isEmpty() || loginUserRequest.getPassword().isBlank())
      throw new FieldPasswordRequiredException();

    Optional<User> user = userRepo.findByEmail(loginUserRequest.getEmail());

    if (user.isEmpty())
      throw new UserDoNotExistException();

    return ServiceResponse.success(
        new LoginUserResponse(
            user.get().getId(),
            user.get().getName(),
            user.get().getEmail()
        ),
        "Usuário autenticado com sucesso",
        200
    );
  }

  public ServiceResponse<ListAllUsersResponse> listAllUsers() {
    List<User> users = userRepo.findAll();

    if (users.isEmpty())
      throw new UserDoNotExistException();

    List<InformationUserResponse> userResponseList = users.stream()
        .map(user -> new InformationUserResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getIsActive(),
            user.getCreatedAt(),
            user.getUpdatedAt()
        )).toList();

    return ServiceResponse.success(
        new ListAllUsersResponse(userResponseList),
        "Lista de usuários obtida com sucesso",
        200
    );
  }
}
