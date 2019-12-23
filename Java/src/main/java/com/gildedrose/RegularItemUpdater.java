package com.gildedrose;

public final class RegularItemUpdater implements ItemUpdater {
	@Override
	public void update(Item item) {
		ItemQualityUpdater.update(item, -1);
		if (item.sellIn < 0) {
			ItemQualityUpdater.update(item, -1);
		}
	}
}
