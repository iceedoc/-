package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountProduct(String name, int basePrice, int discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть строго больше нуля");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно");
        }
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public double getPrice() {
        return (int) Math.round(basePrice * (100 - discountPercent) / 100.0);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}