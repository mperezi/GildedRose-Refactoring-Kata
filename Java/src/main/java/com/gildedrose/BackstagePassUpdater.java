package com.gildedrose;

public final class BackstagePassUpdater implements ItemUpdater {
	private static final int DEADLINE_1 = 10;
	private static final int DEADLINE_2 = 5;

	@Override
	public void update(Item item) {
		if (item.sellIn < 0) {
			ItemQualityShifter.shift(item, -item.quality);
		} else if (item.sellIn < DEADLINE_2) {
			ItemQualityShifter.shift(item, 3);
		} else if (item.sellIn < DEADLINE_1) {
			ItemQualityShifter.shift(item, 2);
		} else {
			ItemQualityShifter.shift(item, 1);
		}
	}
}
