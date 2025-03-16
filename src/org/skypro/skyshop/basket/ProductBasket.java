package org.skypro.skyshop.basket;


import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {

    private final Product[] products = new Product[6];
    private int productCount = 0;

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
            System.out.println("Продукт " + product.getName() + " добавлен в корзину.");
        } else {
            System.out.println("Невозможно добавить продукт.");
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public void printBasket() {
        if (productCount == 0) {
            System.out.println("В корзине пусто.");
            return;
        }

        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProduct(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(products, null);
        productCount = 0;
        System.out.println("Корзина очищена.");
    }
}
