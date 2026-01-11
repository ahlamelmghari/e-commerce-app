package com.ahlam.e_commerce_app.controller;

import com.ahlam.e_commerce_app.model.Cart;
import com.ahlam.e_commerce_app.model.Product;
import com.ahlam.e_commerce_app.service.CartService;
import com.ahlam.e_commerce_app.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    // Voir le contenu 
    @GetMapping
    public Cart getCart() {
        return cartService.getCart();
    }

    // Ajouter un produit au panier par son ID
    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            cartService.addToCart(product);
            return "Product added to cart";
        }
        return "Product not found";
    }

    // Supprimer un produit du panier par son ID
    @DeleteMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return "Product removed from cart";
    }

    // Vider le panier
    @DeleteMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "Cart cleared";
    }

    // Voir le total du panier
    @GetMapping("/total")
    public double getCartTotal() {
        return cartService.getCart().getTotal();
    }
}
