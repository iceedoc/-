package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printContents() {
        int total = 0;
        int specialCount = 0;

        for (Product p : products) {
            System.out.println(p);
            total += p.getPrice();
            if (p.isSpecial()) specialCount++;
        }

        System.out.printf("Итого: %d%n", total);
        System.out.printf("Специальных товаров: %d%n", specialCount);
    }
}
