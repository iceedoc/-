package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ProductBasket {
    private final List<Product> products = new ArrayList<>();
    public boolean addProduct(Product product) {
        if (product == null) {
            throw new NullPointerException("Продукт не может быть null");
        }
        return products.add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
    public int size() {
        return products.size();
    }

    public void printBasket() {
        System.out.println("Содержимое корзины:");
        products.forEach(p -> System.out.println("- " + p.getName()));
    }
}