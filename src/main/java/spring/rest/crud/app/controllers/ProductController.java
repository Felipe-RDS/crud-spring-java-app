package spring.rest.crud.app.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import spring.rest.crud.app.domain.dto.RequestProductDTO;
import spring.rest.crud.app.domain.entities.product.Product;
import spring.rest.crud.app.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService service;

  @GetMapping("/list")
  public String viewProducts(Model model) {
    model.addAttribute("products", service.getAllProducts());
    return "product/list";
  }

  @GetMapping("/add")
  public String addProductForm(Model model) {
    model.addAttribute("product", new Product());
    return "product/add";
  }

  @PostMapping("/add")
  public String addProduct(@ModelAttribute("product") @Valid RequestProductDTO data) {
    Product newProduct = new Product(data);
    service.addProduct(newProduct);
    return "redirect:/product";
  }

  @GetMapping("/edit/{id}")
  public String editProductForm(@PathVariable String id, Model model) {
    Product product = service.getProductById(id);
    model.addAttribute("product", product);
    return "product/edit";
  }

  @PostMapping("/edit/{id}")
  public String editProduct(@PathVariable String id, @ModelAttribute("product") @Valid Product product) {
    RequestProductDTO data = new RequestProductDTO(product.getId(), product.getName(), product.getPrice_in_cents());
    service.updateProduct(data);
    return "redirect:/product";
  }

  @PostMapping("/delete/{id}")
  public String deleteProduct(@PathVariable String id) {
    service.deleteProduct(id);
    return "redirect:/product";
  }
}
