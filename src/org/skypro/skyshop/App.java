package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {
        Product product1 = new Product("Макароны", 40);
        Product product2 = new Product("Картофель", 30);
        Product product3 = new Product("Гречка", 50);
        Product product4 = new Product("Котлеты", 100);
        Product product5 = new Product("Молоко", 90);
        Product product6 = new Product("Колбаса", 200);

        ProductBasket basket = new ProductBasket();

        System.out.println("Добавление продукта в корзину:");
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        System.out.println("Добавление продукта в заполненную корзину:");
        basket.addProduct(product6);

        System.out.println("Содержимое корзины:");
        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        System.out.println("Поиск товара в корзине:");
        System.out.println("Есть макароны: " + basket.containsProduct("Макароны"));
        System.out.println("Есть колбасу: " + basket.containsProduct("Колбасу"));

        System.out.println("Очистка корзины:");
        basket.clearBasket();

        System.out.println("Содержимое корзины после очистки:");
        basket.printBasket();

        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalPrice());

        System.out.println("Поиск товара в пустой корзине:");
        System.out.println("Есть макароны: " + basket.containsProduct("Макароны"));
    }
}