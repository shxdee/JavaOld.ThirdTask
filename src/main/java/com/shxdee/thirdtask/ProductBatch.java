package main;

import java.util.Arrays;
import java.util.Objects;

/*Класс «Партия товаров». Партия товаров имеет описание и содержит некоторое
        количество упакованных товаров, возможно, разных типов (в том числе наборов
        товаров). Методы: конструктор по произвольному набору упаковок товаров,
        получить массу всей партии (суммарная масса брутто всех товаров в партии).*/

public class ProductBatch {
    private final String description;
    private final PackagedProduct[] products;

    public ProductBatch(String description, PackagedProduct... products) {
        if (description == null) throw new IllegalArgumentException();
        this.description = description;
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public PackagedProduct[] getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductBatch)) return false;
        ProductBatch that = (ProductBatch) o;
        return Objects.equals(getDescription(), that.getDescription()) && Arrays.equals(getProducts(), that.getProducts());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getDescription());
        result = 31 * result + Arrays.hashCode(getProducts());
        return result;
    }

    @Override
    public String toString() {
        return String.format("Партия товаров: %s %nТовары: %s", description, Arrays.toString(products));
    }

    public static double getProductWeight(PackagedProduct... products) {
        return Arrays.stream(products).mapToDouble(PackagedProduct::getGrossWeight).sum();
    }

    public double getWeight() {
        return getProductWeight(products);
    }

}
