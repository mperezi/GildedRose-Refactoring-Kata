package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    @Test
    void givenItemWithQualityZero_whenUpdate_ThenQualityStillZero() {
        Item[] items = { ItemMother.random().withQuality(MIN_QUALITY).build() };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(MIN_QUALITY, app.items[0].quality);
    }

    @Test
    void givenSpecialItemWithQualityFifty_whenUpdate_ThenQualityStillFifty() {
        Item[] items = { ItemMother.random().withName("Aged Brie").withQuality(MAX_QUALITY).build() };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(MAX_QUALITY, app.items[0].quality);
    }

    @Test
    void givenSpecialItem_whenUpdate_ThenQualityIncreases() {
        Item agedBrie = ItemMother.agedBrie().build();
        Item backstage = ItemMother.backstage().build();
        Item[] items = {agedBrie, backstage};
        int initialQualityAgedBrie = agedBrie.quality;
        int initialQualityBackstage = backstage.quality;
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(agedBrie.quality > initialQualityAgedBrie);
        assertTrue(backstage.quality > initialQualityBackstage);
    }

    @Test
    void givenLegendaryItem_whenUpdate_ThenQualityDontDecrease() {
        Item[] items = { ItemMother.legendary().build() };
        int initialQuality = items[0].quality;
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertFalse(app.items[0].quality < initialQuality);
    }

    @Test
    void givenLegendaryItem_whenUpdate_ThenSellInDontDecrease() {
        Item[] items = { ItemMother.legendary().build() };
        int initialSellIn = items[0].sellIn;
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertFalse(app.items[0].sellIn < initialSellIn);
    }

    @Test
    void givenBackstageAndSellInUnderTen_whenUpdate_ThenQualityIncreasesBy2() {
        Item[] items = { ItemMother.backstage().withSellIn(10).build() };
        int initialQuality = items[0].quality;
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(initialQuality+2, items[0].quality);
    }

    @Test
    void givenBackstageAndSellInUnderFive_whenUpdate_ThenQualityIncreasesBy3() {
        Item[] items = { ItemMother.backstage().withSellIn(5).build() };
        int initialQuality = items[0].quality;
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(initialQuality+3, items[0].quality);
    }

    @Test
    void givenBackstageAndSellInZero_whenUpdate_ThenQualityDropsToZero() {
        Item[] items = { ItemMother.backstage().withSellIn(0).build() };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
    }

    @Test
    void givenItemWithSellInZero_whenUpdate_ThenQualityDegradesTwice() {
        Item[] items = { ItemMother.random().withSellIn(0).build() };
        int initialQuality = items[0].quality;
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(initialQuality-2, items[0].quality);
    }
}
