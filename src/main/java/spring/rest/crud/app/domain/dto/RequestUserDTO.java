package spring.rest.crud.app.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record RequestUserDTO(
  @NotBlank String username,
  @NotBlank String password,
  @NotNull Set<String> roles
) {}

