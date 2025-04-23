package org.skypro.skyshop;

import org.skypro.skyshop.Art.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Телефон", 3000));
        basket.addProduct(new DiscountProduct("Умные часы", 1000, 100));
        basket.addProduct(new SimpleProduct("Телефон", 3500));
        List<Product> removed = basket.removeProductsByName("Телефон");
        System.out.println("Удаленные продукты:");
        removed.forEach(p -> System.out.println(p.getName()));
        basket.printBasket();
        removed = basket.removeProductsByName("Чехол");
        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        }
        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Монитор", 15000));
        engine.add(new Article("Обзор", "Новинка монитора"));
        List<Searchable> results = engine.search("часы");
        System.out.println("\nРезультаты поиска:");
        results.forEach(r -> System.out.println(r.getStringRepresentation()));
    }
}