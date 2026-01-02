package com.ahlam.e_commerce_app.service;

import com.ahlam.e_commerce_app.model.Cart;
import com.ahlam.e_commerce_app.model.Product;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private Cart cart = new Cart();

    public Cart getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public void removeFromCart(Long productId) {
        cart.removeProduct(productId);
    }

    public void clearCart() {
        cart.clearCart();
    }
}
