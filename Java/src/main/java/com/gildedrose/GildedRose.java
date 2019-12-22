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

    private void updateItemQuality(Item item, int delta) {
        int newQuality = item.quality + delta;
        if (newQuality >= MIN_QUALITY && newQuality <= MAX_QUALITY) {
            item.quality = newQuality;
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(LEGENDARY_ITEM)) continue;

            switch (item.name) {
                case AGED_BRIE_ITEM:
                    updateItemQuality(item, 1);
                    break;
                case BACKSTAGE_PASS_ITEM:
                    updateItemQuality(item , 1);
                    if (item.sellIn < BACKSTAGE_DEADLINE_1) {
                        updateItemQuality(item, 1);
                    }
                    if (item.sellIn < BACKSTAGE_DEADLINE_2) {
                        updateItemQuality(item, 1);
                    }
                    break;
                default:
                    updateItemQuality(item, -1);
                    break;
            }

            item.sellIn -= 1;

            if (item.sellIn < 0) {
                switch (item.name) {
                    case AGED_BRIE_ITEM:
                        updateItemQuality(item, 1);
                        break;
                    case BACKSTAGE_PASS_ITEM:
                        updateItemQuality(item, -item.quality);
                        break;
                    default:
                        updateItemQuality(item, -1);
                        break;
                }
            }
        }
    }
}