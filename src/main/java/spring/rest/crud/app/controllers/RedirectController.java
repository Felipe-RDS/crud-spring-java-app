package spring.rest.crud.app.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
  @GetMapping("/")
  public String handleRootRedirect(Authentication authentication) {
    if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
      return "redirect:/admin/menu";
    }
    return "redirect:/product/list";
  }

  @GetMapping("/product")
  public String handleProductRedirect(Authentication authentication) {
    if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
      return "redirect:/product/list";
    }
    return "redirect:/error/403";
  }
}
