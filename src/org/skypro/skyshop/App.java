package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Чипсы", 60 ));
        basket.addProduct(new DiscountedProduct("Виски", 2000, 15));
        basket.addProduct(new FixPriceProduct("Печенье"));

        basket.printContents();
    }
}