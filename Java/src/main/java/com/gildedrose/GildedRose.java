package com.gildedrose;

import java.util.Arrays;
import java.util.function.Predicate;

class GildedRose {
    static final String AGED_BRIE_ITEM = "Aged Brie";
    static final String BACKSTAGE_PASS_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    static final String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";
    private static final Predicate<Item> REGULAR_ITEM_FILTER =
            item -> !item.name.equals(LEGENDARY_ITEM) &&
                    !item.name.equals(AGED_BRIE_ITEM) &&
                    !item.name.equals(BACKSTAGE_PASS_ITEM);

    Item[] items;
    private final FilteredUpdater itemUpdater = new FilteredUpdater();

    public GildedRose(Item[] items) {
        this.items = items;
        itemUpdater.setFilter(item -> !item.name.equals(LEGENDARY_ITEM), new SellInDecreaser())
                   .setFilter(item -> item.name.equals(AGED_BRIE_ITEM), new AgedBrieUpdater())
                   .setFilter(item -> item.name.equals(BACKSTAGE_PASS_ITEM), new BackstagePassUpdater())
                   .setFilter(REGULAR_ITEM_FILTER, new RegularItemUpdater());
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(itemUpdater::update);
    }
}