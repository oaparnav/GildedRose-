package com.gildedrose.productos;

import com.gildedrose.Item;

public interface Product {
	
	public void updateQuality(Item item);
	public void updateSellIn(Item item);
	public default void updateProductQualityAndSellInFor(Item item) {
		updateSellIn(item);
		updateQuality(item);
	}

}
