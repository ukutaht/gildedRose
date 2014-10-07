package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    public static final int SELL_IN = 10;
    public static final int QUALITY = 15;
    private Item agedBrie;
    private List<Item> items;
    private GildedRose gildedRose;
    private static int MAX_QUALITY = 50;

    @Before
    public void setUp(){
        agedBrie = new Item("Aged Brie", SELL_IN, QUALITY);
        items = Arrays.asList(agedBrie);
        gildedRose = new GildedRose(items);
    }

    @Test
    public void updateQualityDecrementsSellIn() {
        gildedRose.updateQuality();
        assertEquals(SELL_IN - 1, agedBrie.sellIn);
    }

    @Test
    public void updateQualityIncreasesQuality() {
        gildedRose.updateQuality();
        assertEquals(QUALITY + 1, agedBrie.quality);
    }

    @Test
    public void qualityIncreasesTwiceAsFastAfterSellIn() {
        for (int i = 0; i < SELL_IN + 1; i++) {
            gildedRose.updateQuality();
        }

        assertEquals(SELL_IN + QUALITY + 2, agedBrie.quality);
    }

    @Test
    public void qualityisCapped() {
        for (int i = 0; i < MAX_QUALITY; i++) {
            gildedRose.updateQuality();
        }
        assertEquals(MAX_QUALITY, agedBrie.quality);
    }
}
