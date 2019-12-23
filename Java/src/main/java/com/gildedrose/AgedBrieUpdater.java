package com.gildedrose;

public final class AgedBrieUpdater implements ItemUpdater {
	@Override
	public void update(Item item) {
		ItemQualityShifter.shift(item, item.sellIn >= 0 ? 1 : 2);
	}
}
