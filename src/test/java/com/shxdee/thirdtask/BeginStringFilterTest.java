package main;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class BeginStringFilterTest {
    BeginStringFilter filter = new BeginStringFilter("мама");

    @Test
    public void testGetPattern() {
        assertEquals(filter.getPattern(), "мама");
    }

    @Test
    public void testApplyOK() {
        assertTrue(filter.apply("мама мыла раму"));
    }

    @Test
    public void testApplyFalse() {
        assertFalse(filter.apply("папа мыл раму"));
    }
}