package com.gildedrose;

public final class ItemQualityUpdater {
	private static final int MIN_QUALITY = 0;
	private static final int MAX_QUALITY = 50;

	public static void update(Item item, int delta) {
		int newQuality = item.quality + delta;
		if (newQuality >= MIN_QUALITY && newQuality <= MAX_QUALITY) {
			item.quality = newQuality;
		}
	}
}
