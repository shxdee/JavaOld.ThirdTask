package main;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ProductBatchTest {
    ProductPackaging box = new ProductPackaging("Коробка", 10.0);
    PackagedWeightProduct[] fruits = {new PackagedWeightProduct(box, 5.0, new WeightProduct("Бананы", "Яблоки"))};

    ProductBatch fruitBatch = new ProductBatch("Партия фруктов", fruits);

    @Test
    public void testGetDescription() {
        assertEquals(fruitBatch.getDescription(), "Партия фруктов");
    }

    @Test
    public void testGetProducts() {
        assertEquals(fruitBatch.getProducts(), fruits);
    }

    @Test
    public void testGetWeight() {
        assertEquals(fruitBatch.getWeight(), 15.0);
    }
}