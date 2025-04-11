import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Простой продукт", 100));
        engine.add(new SimpleProduct("Продукт для поиска", 200));
        engine.add(new SimpleProduct("Поиск продукта", 300));

        try {
            Product product1 = new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании product1: " + e.getMessage());
        }

        try {
            Searchable bestMatch = engine.findBestMatch("продукт");
            System.out.println("Лучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка при поиске лучшего результата: " + e.getMessage());
        }

        try {
            Searchable bestMatch = engine.findBestMatch("не существует");
            System.out.println("Лучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка при поиске лучшего результата: " + e.getMessage());
        }
    }
}