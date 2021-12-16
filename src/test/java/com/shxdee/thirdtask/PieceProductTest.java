package main;

import org.testng.annotations.Test;

public class PieceProductTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public static void testConstructorNegativeWeight() {
        PieceProduct product = new PieceProduct("Name", "description", -10.0);
    }

}