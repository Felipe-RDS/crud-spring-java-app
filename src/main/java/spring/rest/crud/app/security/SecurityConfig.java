package spring.rest.crud.app.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import spring.rest.crud.app.services.impl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final CustomUserDetailsService customUserDetailsService;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests((authorize) -> authorize
        .requestMatchers("/user/register", "/user/login").permitAll()
        .requestMatchers("/product/list").hasAnyRole("USER", "ADMIN")
        .requestMatchers("/product/").hasRole("ADMIN")
        .requestMatchers("/product/**").hasRole("ADMIN")
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/").authenticated()
        .anyRequest().authenticated()
      )
      .formLogin(formLogin -> formLogin
        .loginPage("/user/login")
        .successHandler((request, response, authentication) -> {
          var authorities = authentication.getAuthorities();
          if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")))
            response.sendRedirect("/admin/menu");
          else
            response.sendRedirect("/product/list");
        })
        .permitAll())
      .exceptionHandling((exception) -> exception.accessDeniedHandler(customAccessDeniedHandler()))
      .logout((logout) -> logout
        .logoutUrl("/user/logout")
        .logoutSuccessUrl("/user/login?logout")
        .permitAll())
      .csrf(CsrfConfigurer::disable);

    return http.build();
  }

  @Bean
  public AccessDeniedHandler customAccessDeniedHandler() {
    return ((request, response, accessDeniedException) -> {
      response.setStatus(HttpStatus.FORBIDDEN.value()); // Define o status 403
      request.setAttribute("javax.servlet.error.status_code", HttpStatus.FORBIDDEN.value());
      request.getRequestDispatcher("/error/403").forward(request, response);
    });
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
    auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    return auth.build();
  }
}

