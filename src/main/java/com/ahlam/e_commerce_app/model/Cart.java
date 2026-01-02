package com.ahlam.e_commerce_app.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items = new ArrayList<>();

    public List<Product> getItems() {
        return items;
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(Long productId) {
        items.removeIf(p -> p.getId().equals(productId));
    }

    public double getTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public void clearCart() {
        items.clear();
    }
}
