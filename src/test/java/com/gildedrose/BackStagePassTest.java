package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BackStagePassTest {

    public static final int SELL_IN = 20;
    public static final int QUALITY = 15;
    private Item backstagePass;
    private List<Item> items;
    private GildedRose gildedRose;
    private static int MAX_QUALITY = 50;

    @Before
    public void setUp() {
        backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", SELL_IN, QUALITY);
        items = Arrays.asList(backstagePass);
        gildedRose = new GildedRose(items);
    }

    public void setUp(int sellIn, int quality) {
        backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        items = Arrays.asList(backstagePass);
        gildedRose = new GildedRose(items);
    }

    @Test
    public void updateQualityDecrementsSellIn() {
        gildedRose.updateQuality();
        assertEquals(SELL_IN - 1, backstagePass.sellIn);
    }

    @Test
    public void updateQualityIncreasesQuality() {
        gildedRose.updateQuality();
        assertEquals(QUALITY + 1, backstagePass.quality);
    }

    @Test
    public void qualityIncreasesBy2When10DaysLeft() {
        setUp(10, 20);
        gildedRose.updateQuality();
        assertEquals(22, backstagePass.quality);
    }

    @Test
    public void qualityIncreasesBy3When5DaysLeft() {
        setUp(5, 20);
        gildedRose.updateQuality();
        assertEquals(23, backstagePass.quality);
    }

    @Test
    public void qualityDropsToZeroAfterConcert() {
        setUp(0, 20);
        gildedRose.updateQuality();
        assertEquals(0, backstagePass.quality);
    }

    @Test
    public void qualityisCapped() {
        setUp(5, MAX_QUALITY);
        gildedRose.updateQuality();
        assertEquals(MAX_QUALITY, backstagePass.quality);
    }
}
