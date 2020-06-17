package com.gildedrose;

import com.gildedrose.productos.AgedBrie;
import com.gildedrose.productos.HandOfRagnaros;
import com.gildedrose.productos.MaskOfSunshine;
import com.gildedrose.productos.OtherProducts;
import com.gildedrose.productos.TAFKAL80ETCConcert;

import lombok.Data;

@Data
public class Item {

	public String name;

	public int sellIn;

	public int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;
	}

	void updateItem(GildedRose gildedRose) {
		switch (name) {
		case "Backstage passes to a TAFKAL80ETC concert" :
			new TAFKAL80ETCConcert().updateProductQualityAndSellInFor(this);
			break;

		case "Aged Brie" :
			new AgedBrie().updateProductQualityAndSellInFor(this);
			break;

		case "mask of sunshine" :
			new MaskOfSunshine().updateProductQualityAndSellInFor(this);
			break;

		case "Sulfuras, Hand of Ragnaros" :
			new HandOfRagnaros().updateProductQualityAndSellInFor(this);
			break;

		default :
			new OtherProducts().updateProductQualityAndSellInFor(this);
			break;

		}
	}
}
