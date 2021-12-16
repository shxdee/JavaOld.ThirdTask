package main;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ProductServiceTest {

    private ProductBatch batch;
    private ProductBatch weightBatch;

    @BeforeMethod
    public void setUp() {
        ProductPackaging productPackaging = new ProductPackaging("коробка", 10.0);
        PieceProduct balls = new PieceProduct("мячи", "футбольные", 100.0);
        PackagedPieceProduct ballBox = new PackagedPieceProduct(productPackaging, 10, balls);
        PackagedProductSet set = new PackagedProductSet("игрушки", "разные игрушки", productPackaging, ballBox, ballBox);
        batch = new ProductBatch("Партия товаров", ballBox,
                set, new PackagedProductSet("не игрушки", "какие-то футболки", productPackaging, ballBox, set));
        WeightProduct weightProduct = new WeightProduct("машинки", "гоночные");
        PackagedWeightProduct racecarBox = new PackagedWeightProduct(productPackaging, 100.0, weightProduct);
        weightBatch = new ProductBatch("Партия машинок", racecarBox);
    }


    @Test
    public void testCounter() {
        assertEquals(ProductService.countByFilter(batch, new BeginStringFilter("мячи")), 1);
        assertEquals(ProductService.countByFilter(batch, new ContainsStringFilter("футбольные")), 0);
        assertEquals(ProductService.countByFilter(batch, new BeginStringFilter("игрушки")), 1);
    }

    @Test
    public void testCheckAllWeighted() {
        assertFalse(ProductService.checkAllWeighted(batch));
        assertTrue(ProductService.checkAllWeighted(weightBatch));
    }

    @Test
    public void testDeepCounter() {
        assertEquals(ProductService.countByFilterDeep(batch, new BeginStringFilter("мячи")), 3);
        assertEquals(ProductService.countByFilterDeep(weightBatch, new EndStringFilter("машинки")), 1);
    }
}