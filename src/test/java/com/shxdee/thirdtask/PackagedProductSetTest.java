package main;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PackagedProductSetTest {
    ProductPackaging box = new ProductPackaging("коробка", 10.0);
    PieceProduct ball = new PieceProduct("мяч", "футбольный", 200.0);
    PackagedPieceProduct ballBox = new PackagedPieceProduct(box, 10, ball);
    PackagedPieceProduct[] products = {ballBox, ballBox};
    PackagedProductSet set = new PackagedProductSet("игрушки", "много мячиков", box, products);

    @Test
    public void testGetProducts() {
        assertEquals(set.getProducts(), products);
    }

    @Test
    public void testGetNetWeight() {
        assertEquals(set.getNetWeight(), 4020.0);
    }

    @Test
    public void testGetGrossWeight() {
        assertEquals(set.getGrossWeight(), 4030.0);
    }
}