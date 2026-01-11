package com.ahlam.e_commerce_app.service;

import com.ahlam.e_commerce_app.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1L, "Laptop", 8000));
        products.add(new Product(2L, "Phone", 4000));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Ajouter un produit
    public Product addProduct(Product product) {
        product.setId((long) (products.size() + 1));
        products.add(product);
        return product;
    }

    // Mise a jour  un produit
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProductById(id);
        if (product != null) {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
        }
        return product;
    }

    // Supprimer un produit
    public boolean deleteProduct(Long id) {
        Product product = getProductById(id);
        if (product != null) {
            products.remove(product);
            return true;
        }
        return false;
    }
}
