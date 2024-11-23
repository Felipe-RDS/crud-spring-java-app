package spring.rest.crud.app.domain.entities.product;

import jakarta.persistence.*;
import lombok.*;
import spring.rest.crud.app.domain.dto.RequestProductDTO;

@Table(name = "product")
@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;

  private Integer price_in_cents;

  private Boolean active;

  public Product(RequestProductDTO requestProduct){
    this.name = requestProduct.name();
    this.price_in_cents = requestProduct.price_in_cents();
    this.active = true;
  }
}
