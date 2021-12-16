package main;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ProductPackagingTest {

    ProductPackaging box = new ProductPackaging("коробка", 10.0);
    ProductPackaging box1 = new ProductPackaging("коробка", 10.0);
    String str = "Упаковка коробка с весом 10";

    @Test(expectedExceptions = IllegalArgumentException.class)
    public static void testConstructorNullName() {
        ProductPackaging productPack = new ProductPackaging(null, 10.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public static void testConstructorNegativeWeight() {
        ProductPackaging productPack = new ProductPackaging("Name", -10.0);
    }

    @Test
    public void getNameTest() {
        assertEquals("коробка", box.getName());
    }

    @Test
    public void getWeightTest() {
        assertEquals(10, box.getWeight());
    }

    @Test
    public void toStringTest() {
        assertEquals("Упаковка коробка с весом 10,000000", box.toString());
    }

    @Test
    public void equalsTest() {
        assertTrue(box.equals(box1));
    }

}