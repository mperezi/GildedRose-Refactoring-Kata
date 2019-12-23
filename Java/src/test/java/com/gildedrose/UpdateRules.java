package com.gildedrose;

import java.util.function.Predicate;

public final class UpdateRules {

	static final String AGED_BRIE_ITEM = "Aged Brie";
	static final String BACKSTAGE_PASS_ITEM = "Backstage passes to a TAFKAL80ETC concert";
	static final String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";

	static final Predicate<Item> NON_LEGENDARY_ITEMS = item -> !item.name.equals(LEGENDARY_ITEM);
	static final Predicate<Item> ONLY_AGED_BRIE = item -> item.name.equals(AGED_BRIE_ITEM);
	static final Predicate<Item> ONLY_BACKSTAGE_PASSES = item -> item.name.equals(BACKSTAGE_PASS_ITEM);
	static final Predicate<Item> ONLY_REGULAR_ITEMS = NON_LEGENDARY_ITEMS
			.and(ONLY_AGED_BRIE.negate())
			.and(ONLY_BACKSTAGE_PASSES.negate());

	static FilteredUpdater itemUpdater() {
		return new FilteredUpdater()
				.setFilter(NON_LEGENDARY_ITEMS, new SellInDecreaser())
				.setFilter(ONLY_AGED_BRIE, new AgedBrieUpdater())
				.setFilter(ONLY_BACKSTAGE_PASSES, new BackstagePassUpdater())
				.setFilter(ONLY_REGULAR_ITEMS, new RegularItemUpdater());
	}
}
