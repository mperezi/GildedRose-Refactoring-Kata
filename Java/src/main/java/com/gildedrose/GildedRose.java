package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    Item[] items;
    private final FilteredUpdater itemUpdater;

    public GildedRose(Item[] items, FilteredUpdater itemUpdater) {
        this.items = items;
        this.itemUpdater = itemUpdater;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(itemUpdater::update);
    }
}