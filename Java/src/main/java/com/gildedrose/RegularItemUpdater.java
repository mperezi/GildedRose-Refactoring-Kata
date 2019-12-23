package com.gildedrose;

public final class RegularItemUpdater implements ItemUpdater {
	@Override
	public void update(Item item) {
		ItemQualityUpdater.update(item, item.sellIn >= 0 ? -1 : -2);
	}
}
