package main;

import org.testng.annotations.Test;

public class WeightProductTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public static void testConstructorNullName() {
        WeightProduct product = new WeightProduct(null, "description");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public static void testConstructorNullDescription() {
        WeightProduct product = new WeightProduct("Name", null);
    }
}