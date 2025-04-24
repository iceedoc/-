package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.Art.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Кофе", 150));
        basket.addProduct(new SimpleProduct("Кофе", 150));
        basket.addProduct(new FixPriceProduct("Чай"));
        basket.addProduct(new DiscountProduct("Сахар", 100, 10));


        System.out.println("Содержимое корзины:");
        basket.printContents();
        System.out.println("Общая стоимость: " + basket.getTotalPrice() + " руб.");


        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Кофе", 150));
        engine.add(new FixPriceProduct("Чай"));
        engine.add(new Article("Как сделать кофе", "Инструкция..."));

        System.out.println("\nРезультаты поиска:");
        Map<String, Searchable> results = engine.search("Кофе");
        results.forEach((name, item) ->
                System.out.println(name + " (" + item.getContentType() + ")")
        );
    }
}