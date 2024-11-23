package spring.rest.crud.app.services;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.rest.crud.app.domain.entities.user.User;
import java.util.Optional;

@Service
public interface UserService {
  void register(User user, PasswordEncoder passwordEncoder);
  Optional<User> findByUsername(String username);
  Iterable<User> findAllUsers();
}