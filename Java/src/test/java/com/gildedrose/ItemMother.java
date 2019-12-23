package com.gildedrose;

import static com.gildedrose.UpdateRules.AGED_BRIE_ITEM;
import static com.gildedrose.UpdateRules.BACKSTAGE_PASS_ITEM;
import static com.gildedrose.UpdateRules.LEGENDARY_ITEM;

public final class ItemMother {

	public static ItemBuilder random() {
		return new ItemBuilder().withName("my item").withSellIn(5).withQuality(9);
	}

	public static ItemBuilder legendary() {
		return random().withName(LEGENDARY_ITEM);
	}

	public static ItemBuilder agedBrie() {
		return random().withName(AGED_BRIE_ITEM);
	}

	public static ItemBuilder backstage() {
		return random().withName(BACKSTAGE_PASS_ITEM);
	}

	static class ItemBuilder {
		private String name;
		private int sellIn;
		private int quality;

		public ItemBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public ItemBuilder withSellIn(int sellIn) {
			this.sellIn = sellIn;
			return this;
		}

		public ItemBuilder withQuality(int quality) {
			this.quality = quality;
			return this;
		}

		public Item build() {
			return new Item(name, sellIn, quality);
		}
	}
}
