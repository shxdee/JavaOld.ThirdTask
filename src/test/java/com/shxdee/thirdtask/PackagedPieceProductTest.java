package main;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PackagedPieceProductTest {
    PieceProduct product = new PieceProduct("мяч", "футбольный", 200.00);
    PackagedPieceProduct packagedProduct = new PackagedPieceProduct(new ProductPackaging("коробка", 10.0),
            10, product);


    @Test
    public void testGetCount() {
        assertEquals(packagedProduct.getCount(), 10);
    }

    @Test
    public void testGetProduct() {
        assertEquals(packagedProduct.getProduct(), product);
    }

    @Test
    public void testGetNetWeight() {
        assertEquals(packagedProduct.getNetWeight(), 2000.0);
    }

    @Test
    public void testGetGrossWeight() {
        assertEquals(packagedProduct.getGrossWeight(), 2010.0);
    }
}