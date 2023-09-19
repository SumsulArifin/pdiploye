package com.tkgroupbd.pusti.api.data.payloads.requests.users;

import com.tkgroupbd.pusti.api.data.models.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

  @NotBlank(message = "Invalid First Name: First name is empty.")
  @NotNull(message = "Invalid First Name: First name is NULL")
  @Size(min = 3, max = 30, message = "Invalid First Name: Must be of 3 - 30 characters")
  private String firstname;

  private String lastname;

  @NotNull
  @NotEmpty(message = "Email is empty")
  @Email(message = "Invalid email")
  private String email;

  @NotBlank(message = "Invalid Password: Password is empty.")
  @NotNull(message = "Invalid Password: Password is NULL")
  @Size(min = 3, max = 30, message = "Invalid Password: Must be of 6 - 12 characters")
  private String password;

  private Role role;
}
