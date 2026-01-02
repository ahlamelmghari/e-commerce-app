package com.ahlam.e_commerce_app.service;

import com.ahlam.e_commerce_app.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService service;

    @BeforeEach
    void setUp() {
        service = new ProductService();
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = service.getAllProducts();
        assertEquals(2, products.size());
    }

    @Test
    void testAddProduct() {
        Product newProduct = new Product(null, "Tablet", 3000);
        Product added = service.addProduct(newProduct);

        assertNotNull(added.getId());
        assertEquals("Tablet", added.getName());
        assertEquals(3, service.getAllProducts().size());
    }

    @Test
    void testUpdateProduct() {
        Product updated = new Product(null, "Laptop Pro", 9000);
        Product result = service.updateProduct(1L, updated);

        assertEquals("Laptop Pro", result.getName());
        assertEquals(9000, result.getPrice());
    }

    @Test
    void testDeleteProduct() {
        boolean deleted = service.deleteProduct(2L);
        assertTrue(deleted);
        assertEquals(1, service.getAllProducts().size());
    }

    @Test
    void testGetProductById() {
        Product product = service.getProductById(1L);
        assertNotNull(product);
        assertEquals("Laptop", product.getName());
    }
}
