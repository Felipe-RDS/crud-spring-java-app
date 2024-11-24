package spring.rest.crud.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.rest.crud.app.services.UserService;

@RequestMapping("/admin/users")
@Controller
public class AdminController {
  @Autowired
  private UserService userService;

  @GetMapping("/list")
  public String listUsers(Model model) {
    model.addAttribute("users", userService.findAllUsers());
    return "admin/user_list";
  }
}
