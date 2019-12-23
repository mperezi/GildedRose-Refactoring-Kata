package com.gildedrose;

public final class SellInDecreaser implements ItemUpdater {
	@Override
	public void update(Item item) {
		item.sellIn -= 1;
	}
}
