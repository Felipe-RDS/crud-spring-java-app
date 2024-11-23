package spring.rest.crud.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.rest.crud.app.domain.entities.product.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
  List<Product> findAllByActiveTrue();
}
