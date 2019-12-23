package com.gildedrose;

public final class RegularItemUpdater implements ItemUpdater {
	@Override
	public void update(Item item) {
		ItemQualityShifter.shift(item, item.sellIn >= 0 ? -1 : -2);
	}
}
