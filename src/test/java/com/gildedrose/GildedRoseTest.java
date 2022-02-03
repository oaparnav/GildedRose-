package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GildedRoseTest {
	private Item[] items;
	private Item[] backupItems;

    @Test
    public void testForDexterityVest() {
    	items = new Item[] { new Item("+5 Dexterity Vest", 10, 20),
    			new Item("+5 Dexterity Vest", 0, 20),
    			new Item("+5 Dexterity Vest", 10, 60)};
        backupItems = new Item[] { new Item("+5 Dexterity Vest", 10, 20),
        		new Item("+5 Dexterity Vest", 0, 20),
        		new Item("+5 Dexterity Vest", 10, 60)};
        callGildeRoseAndVerifyResponse();
    }

    @Test
    public void testForAgedBrie() {
        items = new Item[] { new Item("Aged Brie", 2, 0),
        		new Item("Aged Brie", 0, 20),
    			new Item("Aged Brie", 10, 60)};
        backupItems = new Item[] { new Item("Aged Brie", 2, 0),
        		new Item("Aged Brie", 0, 20),
    			new Item("Aged Brie", 10, 60)};
        callGildeRoseAndVerifyResponse();
    }
    
    @Test
    public void testForElixirOfTheMongoose() {
        items = new Item[] { new Item("Elixir of the Mongoose", 5, 7),
        		new Item("Elixir of the Mongoose", 0, 20),
    			new Item("Elixir of the Mongoose", 10, 60)};
        backupItems = new Item[] { new Item("Elixir of the Mongoose", 5, 7),
        		new Item("Elixir of the Mongoose", 0, 20),
    			new Item("Elixir of the Mongoose", 10, 60)};
        callGildeRoseAndVerifyResponse();
        
    }
    
    @Test
    public void testForHandOfRagnaros() {
        items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 7),
        		new Item("Sulfuras, Hand of Ragnaros", 0, 20),
    			new Item("Sulfuras, Hand of Ragnaros", 10, 60)};
        backupItems = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 7),
        		new Item("Sulfuras, Hand of Ragnaros", 0, 20),
    			new Item("Sulfuras, Hand of Ragnaros", 10, 60)};
        callGildeRoseAndVerifyResponse();
    }
    
    @Test
    public void testForTAFKAL80ETCConcert() {
        items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        		new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
    			new Item("Backstage passes to a TAFKAL80ETC concert", 10, 60)};
        backupItems = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        		new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
    			new Item("Backstage passes to a TAFKAL80ETC concert", 10, 60)};
        callGildeRoseAndVerifyResponse();
    }
    
    @Test
    public void testForConjuredManaCake() {
        items = new Item[] { new Item("Conjured Mana Cake", 3, 6),
        		new Item("Conjured Mana Cake", 0, 20),
    			new Item("Conjured Mana Cake", 10, 60)};
        backupItems = new Item[] { new Item("Conjured Mana Cake", 3, 6),
        		new Item("Conjured Mana Cake", 0, 20),
    			new Item("Conjured Mana Cake", 10, 60)};
        callGildeRoseAndVerifyResponse();
    }
    
    @Test
    public void testForMoreThanOneProduct() {
        items = new Item[] { new Item("Conjured Mana Cake", 3, 6),
        		new Item("Elixir of the Mongoose", 5, 7), 
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), 
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        		 new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                 new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                 new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        backupItems = new Item[] { new Item("Conjured Mana Cake", 3, 6),
        		new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), 
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        		 new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
                 new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                 new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        callGildeRoseAndVerifyResponse();
    }
    
    @Test
    public void testForMaskOfSunshine() {
        items = new Item[] { new Item("mask of sunshine", 0, 6) };
        Item expected = new Item("mask of sunshine", -1, 2);
        GildedRose app = callNewImplementation();
        assertEquals(expected.name, app.items[0].name);
		assertEquals(expected.quality, app.items[0].quality);
		assertEquals(expected.sellIn, app.items[0].sellIn);
    }
    
    private void callGildeRoseAndVerifyResponse() {
		GildedRose app = callNewImplementation();
        GildedRoseBackUp backup = callOldImplementation();
        validateitems(app, backup);
	}

	private GildedRoseBackUp callOldImplementation() {
		GildedRoseBackUp backup = new GildedRoseBackUp(backupItems);
        backup.updateQuality();
		return backup;
	}

	private GildedRose callNewImplementation() {
		GildedRose app = new GildedRose(items);
        app.updateQuality();
		return app;
	}

	private void validateitems(GildedRose app, GildedRoseBackUp backup) {
		int index = 0;
		for (Item item : app.items) {
			assertEquals(item.name, backup.items[index].name);
			assertEquals(item.quality, backup.items[index].quality);
			assertEquals(item.sellIn, backup.items[index].sellIn);
			index++;
		}
	}

}
