package com.gildedrose;

public final class ItemMother {

	public static ItemBuilder random() {
		return new ItemBuilder().withName("my item").withSellIn(5).withQuality(9);
	}

	public static ItemBuilder legendary() {
		return random().withName("Sulfuras, Hand of Ragnaros");
	}

	public static ItemBuilder agedBrie() {
		return random().withName("Aged Brie");
	}

	public static ItemBuilder backstage() {
		return random().withName("Backstage passes to a TAFKAL80ETC concert");
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
