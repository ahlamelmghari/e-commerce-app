package com.ahlam.e_commerce_app.service;

import com.ahlam.e_commerce_app.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceTest {

    private CartService cartService;
    private Product testProduct;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
        testProduct = new Product(1L, "Laptop", 8000);
    }

    @Test
    void testAddToCart() {
        cartService.addToCart(testProduct);
        assertEquals(1, cartService.getCart().getItems().size());
    }

    @Test
    void testRemoveFromCart() {
        cartService.addToCart(testProduct);
        cartService.removeFromCart(1L);
        assertEquals(0, cartService.getCart().getItems().size());
    }

    @Test
    void testClearCart() {
        cartService.addToCart(testProduct);
        cartService.clearCart();
        assertTrue(cartService.getCart().getItems().isEmpty());
    }

    @Test
    void testGetTotal() {
        Product p2 = new Product(2L, "Phone", 4000);
        cartService.addToCart(testProduct);
        cartService.addToCart(p2);

        assertEquals(12000, cartService.getCart().getTotal());
    }
}
