import org.skypro.skyshop.Art.Article;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        SearchEngine engine = new SearchEngine();

        engine.add(new Article("Новости", "Сегодня  произошло интересное событие"));
        engine.add(new Article("Новинка", "Новый монитор впечатляет"));

        engine.add(new SimpleProduct("Мышь", 99.99));
        engine.add(new SimpleProduct("Клавиатура", 499.49));

        Set<Searchable> results = engine.search("нов");
        results.forEach(System.out::println);
    }
}