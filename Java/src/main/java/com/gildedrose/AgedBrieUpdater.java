package com.gildedrose;

public final class AgedBrieUpdater implements ItemUpdater {
	@Override
	public void update(Item item) {
		ItemQualityUpdater.update(item, item.sellIn >= 0 ? 1 : 2);
	}
}
