package com.gildedrose;

public final class ItemMother {

	public static ItemBuilder random() {
		return new ItemBuilder().withName("my item").withSellIn(5).withQuality(9);
	}

	public static ItemBuilder legendary() {
		return random().withName(GildedRose.LEGENDARY_ITEM);
	}

	public static ItemBuilder agedBrie() {
		return random().withName(GildedRose.AGED_BRIE_ITEM);
	}

	public static ItemBuilder backstage() {
		return random().withName(GildedRose.BACKSTAGE_PASS_ITEM);
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
