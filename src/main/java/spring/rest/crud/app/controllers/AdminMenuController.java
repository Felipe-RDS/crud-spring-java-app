package spring.rest.crud.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminMenuController {
  @GetMapping("/admin/menu")
  public String getAdminMenu(Model model) {
    return "admin/menu";
  }
}
