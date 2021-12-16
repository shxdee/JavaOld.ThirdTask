package main;

import java.util.Arrays;

/*Класс «Упакованный набор товаров». Набор состоит из собственной упаковки и
        некоторого количества упаковок товаров разного вида (в том числе других наборов).
        Методы: конструктор по произвольной последовательности упаковок товаров, масса
        нетто (суммарная масса брутто всех элементов набора, но без массы упаковки самого
        набора), масса брутто (суммарная масса всего набора с упаковкой).*/

public class PackagedProductSet extends PackagedProduct {
    private final PackagedProduct[] products;

    public PackagedProductSet(String name, String description, ProductPackaging productPackaging, PackagedProduct... products) {
        super(name, description, productPackaging);
        this.products = products;
    }

    public PackagedProduct[] getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return String.format("Набор товаров в упаковке %s", productPackaging.getName());
    }

    public static double getProductWeight(PackagedProduct... products) {
        return Arrays.stream(products).mapToDouble(PackagedProduct::getGrossWeight).sum();
    }

    public double getNetWeight() {
        return getProductWeight(getProducts());
    }

    public double getGrossWeight() {
        return getProductWeight(getProducts()) + productPackaging.getWeight();
    }
}
