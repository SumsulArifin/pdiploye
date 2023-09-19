package com.tkgroupbd.pusti.api.controllers.common;

import com.tkgroupbd.pusti.api.data.payloads.requests.users.UserRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.UserResponse;
import com.tkgroupbd.pusti.api.data.payloads.requests.users.UserRegisterRequest;
import com.tkgroupbd.pusti.api.services.user.UserService;

import io.jsonwebtoken.io.IOException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
// @CrossOrigin(origins = { "http://localhost:3000" })
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("/register")
  public ResponseEntity<UserResponse> userRegister(
      @RequestBody @Valid UserRegisterRequest request) {
    return ResponseEntity.ok(userService.UserRegister(request));
  }

  @PostMapping("/login")
  public ResponseEntity<UserResponse> userLogin(
      @RequestBody UserRequest request) {
    return ResponseEntity.ok(userService.UserLogin(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response) throws IOException, java.io.IOException {
    userService.refreshToken(request, response);
  }

}
