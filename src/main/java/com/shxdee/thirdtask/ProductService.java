package main;

import java.util.Arrays;

/*Напишите класс «Сервис товаров» со следующими методами.
        3.1. Метод countByFilter, который получает на вход партию товара и произвольный
        фильтр из п.2. Метод возвращает количество элементов партии, имена которых
        удовлетворяют фильтру. Для товаров-наборов анализируется только название самого
        набора.
        3.2. Метод countByFilterDeep — ведет себя аналогично методу countByFilter, но набор
        считается подходящим, если он содержит (возможно на некоторой глубине) хотя бы
        один товар с названием, удовлетворяющим фильтру.
        3.3. Метод checkAllWeighted, который для партии товаров проверит, что вся партия
        состоит только из весовых товаров.*/

public class ProductService {
    public static int countByFilter(ProductBatch batch, IFilter strFilter) {
        return (int) Arrays.stream(batch.getProducts()).
                filter(x -> strFilter.apply(x.getName())).count();
    }

    public static Boolean checkAllWeighted(ProductBatch batch) {
        return Arrays.stream(batch.getProducts()).
                allMatch(ProductService::checkProductType);
    }

    private static Boolean checkProductType(PackagedProduct product) {
        if (product instanceof PackagedProductSet) {
            PackagedProduct[] products = ((PackagedProductSet) product).getProducts();
            return Arrays.stream(products).
                    anyMatch(ProductService::checkProductType);
        }
        return product instanceof PackagedWeightProduct;
    }

    private static Boolean checkProductName(PackagedProduct product, IFilter strFilter) {
        if (product instanceof PackagedProductSet) {
            PackagedProduct[] products = ((PackagedProductSet) product).getProducts();
            return Arrays.stream(products).
                    anyMatch(x -> checkProductName(x, strFilter));
        }
        return strFilter.apply(product.getName());
    }

    public static int countByFilterDeep(ProductBatch batch, IFilter strFilter) {
        return (int) Arrays.stream(batch.getProducts()).
                filter(x -> checkProductName(x, strFilter)).count();
    }
}
