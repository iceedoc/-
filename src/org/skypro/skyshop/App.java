package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.Art.Article;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine(20);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Макароны", 40));
        basket.addProduct(new SimpleProduct("Картофель", 30));
        basket.addProduct(new SimpleProduct("Гречка", 50));
        basket.addProduct(new SimpleProduct("Молоко", 90));
        basket.addProduct(new SimpleProduct("Колбаса", 200));

        for (int i = 0; i < basket.size(); i++) {
            engine.add(basket.getProducts()[i]);
        }

        engine.add(new Article("Как выбрать телевизор", "Советы по выбору смартфона"));
        engine.add(new Article("Подарочные карты", "Инструкция по оформлению подарочных сертификатов"));
        engine.add(new Article("Скидки и акции", "Как участвовать в распродажах"));

        System.out.println("\nТест поиска по товарам:");
        System.out.println(Arrays.toString(engine.search("яблоко")));

        System.out.println("\nТест поиска по статьям:");
        System.out.println(Arrays.toString(engine.search("подарочные")));

        System.out.println("\nТест поиска по нескольким типам:");
        System.out.println(Arrays.toString(engine.search("с")));

        System.out.println("\nТест поиска с пустым результатом:");
        System.out.println(Arrays.toString(engine.search("не существует")));
    }
}