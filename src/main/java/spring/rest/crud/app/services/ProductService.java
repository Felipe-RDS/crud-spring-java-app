package spring.rest.crud.app.services;

import spring.rest.crud.app.domain.dto.RequestProductDTO;
import spring.rest.crud.app.domain.entities.product.Product;

public interface ProductService {
  Iterable<Product> getAllProducts();

  void addProduct(Product product);

  Product updateProduct(RequestProductDTO data);

  void deleteProduct(String id);

  Product getProductById(String id);

}
