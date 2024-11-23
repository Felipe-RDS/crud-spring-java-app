package spring.rest.crud.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.rest.crud.app.domain.entities.user.User;
import spring.rest.crud.app.services.UserService;
import java.util.Collections;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  @GetMapping("/login")
  public String getLoginPage() {
    return "user/login";
  }

  @GetMapping("/register")
  public String getRegistrationPage(Model model) {
    model.addAttribute("user", new User());
    return "user/register";
  }

  @PostMapping("/register")
  public String registerUser(@ModelAttribute User user) {
    System.out.println("USUARIO: " + user.getUsername() + "\n" + user.getRoles());
    if (user.getRoles() == null || user.getRoles().isEmpty()) {
      user.setRoles(Collections.singleton("USER"));
    }
    userService.register(user, passwordEncoder);
    return "redirect:/login?success";
  }

}
