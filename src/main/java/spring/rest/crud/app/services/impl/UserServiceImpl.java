package spring.rest.crud.app.services.impl;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.rest.crud.app.domain.entities.user.User;
import spring.rest.crud.app.repositories.UserRepository;
import spring.rest.crud.app.services.UserService;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  @Override
  public void register(User user, PasswordEncoder passwordEncoder) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
  }
  @Override
  public Optional<User> findByUsername(String username) {
    return userRepository.findByUsername(username);
  }
  @Override
  public Iterable<User> findAllUsers() {
    return userRepository.findAll();
  }
}