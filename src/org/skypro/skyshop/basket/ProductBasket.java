package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products;
    private int productCount;
    private static final int MAX_SIZE = 5;

    public ProductBasket() {
        this.products = new Product[MAX_SIZE];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount >= MAX_SIZE) {
            System.out.println("Невозможно добавить продукт: корзина заполнена.");
            return;
        }

        products[productCount++] = product;
    }

    public int size() {
        return productCount;
    }

    public Product[] getProducts() {
        return Arrays.copyOf(products, products.length);
    }
}