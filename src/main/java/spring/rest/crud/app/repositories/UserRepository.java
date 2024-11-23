package spring.rest.crud.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.rest.crud.app.domain.entities.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByUsername(String username);
}
