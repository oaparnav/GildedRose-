package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRoseBackUp app = new GildedRoseBackUp(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
