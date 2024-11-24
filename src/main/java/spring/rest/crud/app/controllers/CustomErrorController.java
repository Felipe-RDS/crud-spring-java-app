package spring.rest.crud.app.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
  @RequestMapping("/error")
  public String handleError(HttpServletRequest request, Model model) {
    Object status = request.getAttribute("javax.servlet.error.status_code");
    if (status != null) {
      int statusCode = Integer.parseInt(status.toString());

      if (statusCode == HttpStatus.FORBIDDEN.value()) {
        return "error/403";
      }

    }
    return "error/generic";
  }

}
