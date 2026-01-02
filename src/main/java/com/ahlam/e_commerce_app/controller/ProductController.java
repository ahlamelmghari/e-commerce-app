package com.ahlam.e_commerce_app.controller;

import com.ahlam.e_commerce_app.model.Product;
import com.ahlam.e_commerce_app.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return service.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        boolean deleted = service.deleteProduct(id);
        return deleted ? "Product deleted" : "Product not found";
    }
}
