package com.gildedrose;

public final class BackstagePassUpdater implements ItemUpdater {
	public static final int DEADLINE_1 = 10;
	public static final int DEADLINE_2 = 5;

	@Override
	public void update(Item item) {
		ItemQualityUpdater.update(item, 1);
		if (item.sellIn < DEADLINE_1) {
			ItemQualityUpdater.update(item, 1);
		}
		if (item.sellIn < DEADLINE_2) {
			ItemQualityUpdater.update(item, 1);
		}
		if (item.sellIn < 0) {
			ItemQualityUpdater.update(item, -item.quality);
		}
	}
}
