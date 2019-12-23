package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    Item[] items;
    private final ItemUpdater itemUpdater;

    public GildedRose(Item[] items, ItemUpdater itemUpdater) {
        this.items = items;
        this.itemUpdater = itemUpdater;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(itemUpdater::update);
    }
}