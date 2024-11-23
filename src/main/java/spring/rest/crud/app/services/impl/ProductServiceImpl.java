package spring.rest.crud.app.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rest.crud.app.domain.dto.RequestProductDTO;
import spring.rest.crud.app.domain.entities.product.Product;
import spring.rest.crud.app.repositories.ProductRepository;
import spring.rest.crud.app.services.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository repository;

  @Override
  public Iterable<Product> getAllProducts() {
    return repository.findAllByActiveTrue();
  }

  @Override
  public void addProduct(Product product) {
    repository.save(product);
  }

  @Transactional
  @Override
  public Product updateProduct(RequestProductDTO data) {
    Product product = repository.findById(data.id())
      .orElseThrow(EntityNotFoundException::new
      );
    product.setName(data.name());
    product.setPrice_in_cents(data.price_in_cents());
    if (!product.getActive())
      product.setActive(true);

    return product;
  }

  @Transactional
  @Override
  public void deleteProduct(String id) {
    Product product = repository.findById(id)
      .orElseThrow(() ->
        new EntityNotFoundException("Product Not Found")
      );
    product.setActive(false);
  }

  @Override
  public Product getProductById(String id) {
    Product product = repository.findById(id)
      .orElseThrow(EntityNotFoundException::new
      );

    return product;
  }

}
