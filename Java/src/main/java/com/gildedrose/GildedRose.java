package com.gildedrose;

class GildedRose {
    static final int MAX_QUALITY = 50;
    static final int MIN_QUALITY = 0;
    static final int BACKSTAGE_DEADLINE_1 = 11;
    static final int BACKSTAGE_DEADLINE_2 = 6;

    static final String AGED_BRIE_ITEM = "Aged Brie";
    static final String BACKSTAGE_PASS_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    static final String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE_ITEM)
                && !item.name.equals(BACKSTAGE_PASS_ITEM)) {
                if (item.quality > MIN_QUALITY) {
                    if (!item.name.equals(LEGENDARY_ITEM)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASS_ITEM)) {
                        if (item.sellIn < BACKSTAGE_DEADLINE_1) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < BACKSTAGE_DEADLINE_2) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(LEGENDARY_ITEM)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE_ITEM)) {
                    if (!item.name.equals(BACKSTAGE_PASS_ITEM)) {
                        if (item.quality > MIN_QUALITY) {
                            if (!item.name.equals(LEGENDARY_ITEM)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < MAX_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}