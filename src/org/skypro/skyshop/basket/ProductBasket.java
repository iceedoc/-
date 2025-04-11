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

    public boolean addProduct(Product product) {
        if (product == null) {
            throw new NullPointerException("Продукт не может быть null");
        }

        if (productCount >= MAX_SIZE) {
            return false;
        }

        products[productCount++] = product;
        return true;
    }

    public int size() {
        return productCount;
    }

    public Product[] getProducts() {
        return Arrays.copyOf(products, productCount);
    }
}