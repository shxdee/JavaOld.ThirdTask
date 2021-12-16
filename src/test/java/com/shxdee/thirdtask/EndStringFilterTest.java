package main;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EndStringFilterTest {
    EndStringFilter filter = new EndStringFilter("раму");

    @Test
    public void testGetPattern() {
        assertEquals(filter.getPattern(), "раму");
    }

    @Test
    public void testApplyOK() {
        assertTrue(filter.apply("мама мыла раму"));
    }

    @Test
    public void testApplyFalse() {
        assertFalse(filter.apply("мама мыла посуду"));
        assertFalse(filter.apply("папа мыл посуду"));
    }
}