package main;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PackagedWeightProductTest {
    PackagedWeightProduct product = new PackagedWeightProduct(new ProductPackaging("Коробка", 10.0),
            200, new WeightProduct("Мячи", "Футбольные мячи"));

    @Test(expectedExceptions = IllegalArgumentException.class)
    public static void testConstructorNegativeWeight() {
        PackagedWeightProduct product = new PackagedWeightProduct(new ProductPackaging("Коробка", 10.0),
                -10, new WeightProduct("Мячи", "Футбольные мячи"));
    }

    @Test
    public void testGetNetWeight() {
        assertEquals(product.getNetWeight(), 200);
    }

    @Test
    public void testGetGrossWeight() {
        assertEquals(product.getGrossWeight(), 210);
    }
}