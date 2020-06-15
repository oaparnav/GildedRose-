package com.gildedrose.productos;

import com.gildedrose.Item;

public class AgedBrie implements Product{

	@Override
	public void updateQuality(Item item) {
		checkQualityLessThen50(item);
		if(item.sellIn < 0 && item.quality < 50)
			item.quality = item.quality + 1;
		
	}

	private void checkQualityLessThen50(Item item) {
		if(item.quality < 50)
			item.quality = item.quality + 1;
		
	}

	@Override
	public void updateSellIn(Item item) {
		item.sellIn = item.sellIn - 1;
		
	}

}
