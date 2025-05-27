package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Stream;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product product) {
        Objects.requireNonNull(product, "Продукт не может быть null");
        productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>())
                .add(product);
    }

    public List<Product> removeProductsByName(String name) {
        Objects.requireNonNull(name, "Имя не может быть null");
        return productsMap.remove(name);
    }

    public double getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public List<Product> getAllProducts() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    public void printContents() {
        productsMap.entrySet().stream()
                .flatMap(entry ->
                        Stream.concat(
                                Stream.of(entry.getKey() + ":"),
                                entry.getValue().stream()
                                        .map(p -> "  - " + p.getPrice() + " руб.")
                        )
                )
                .forEach(System.out::println);
    }
}