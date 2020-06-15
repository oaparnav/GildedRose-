package com.gildedrose;

import java.util.Arrays;

import com.gildedrose.productos.AgedBrie;
import com.gildedrose.productos.HandOfRagnaros;
import com.gildedrose.productos.MaskOfSunshine;
import com.gildedrose.productos.OtherProducts;
import com.gildedrose.productos.Product;
import com.gildedrose.productos.TAFKAL80ETCConcert;

class GildedRose {
	Item[] items;
	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		Arrays.asList(items).forEach(item -> updateItem(item));
	}

	private void updateItem(Item item) {
		switch (item.name) {
		case "Backstage passes to a TAFKAL80ETC concert" :
			updateProductQualityAndSellInFor(new TAFKAL80ETCConcert(), item);
			break;

		case "Aged Brie" :
			updateProductQualityAndSellInFor(new AgedBrie(), item);
			break;

		case "mask of sunshine" :
			updateProductQualityAndSellInFor(new MaskOfSunshine(), item);
			break;

		case "Sulfuras, Hand of Ragnaros" :
			updateProductQualityAndSellInFor(new HandOfRagnaros(), item);
			break;

		default :
			updateProductQualityAndSellInFor(new OtherProducts(), item);
			break;

		}
	}

	private void updateProductQualityAndSellInFor(Product product, Item item) {
		product.updateQuality(item);
		product.updateSellIn(item);
	}
}