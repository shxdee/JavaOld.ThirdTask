package main;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ProductTest {

    Product ball = new Product("Мячи", "Футбольные");
    Product ball1 = new Product("Мячи", "Футбольные");
    String str = "Товар Мячи (Футбольные)";

    @Test(expectedExceptions = IllegalArgumentException.class)
    public static void testConstructorNullName() {
        Product product = new Product(null, "description string");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public static void testConstructorNullDescription() {
        Product product = new Product("Name", null);
    }

    @Test
    public void getNameTest() {
        assertEquals("Мячи", ball.getName());
    }

    @Test
    public void getWeightTest() {
        assertEquals("Футбольные", ball.getDescription());
    }

    @Test
    public void toStringTest() { assertEquals("Товар Мячи (Футбольные)", ball.toString());
    }

    @Test
    public void equalsTest() {
        assertTrue(ball.equals(ball1));
    }
}