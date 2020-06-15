package com.gildedrose.productos;

import com.gildedrose.Item;

public class MaskOfSunshine implements Product{

	@Override
	public void updateQuality(Item item) {
		if (item.quality > 0) 
			item.quality = item.quality - 2;
		if (item.sellIn < 0 && item.quality > 0) 
			item.quality = item.quality - 2;
		
	}

	@Override
	public void updateSellIn(Item item) {
		item.sellIn = item.sellIn - 1;
	}

}
