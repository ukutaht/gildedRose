package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackStagePassTest {

    private static final int SELL_IN = 20;
    private static final int QUALITY = 15;
    private Item backstagePass;
    private static int MAX_QUALITY = 50;

    @Before
    public void setUp() {
        setUp(SELL_IN, QUALITY);
    }

    public void setUp(int sellIn, int quality) {
        backstagePass = new BackStagePass(sellIn, quality);
    }

    @Test
    public void updateQualityDecrementsSellIn() {
        backstagePass.updateQuality();
        assertEquals(SELL_IN - 1, backstagePass.sellIn);
    }

    @Test
    public void updateQualityIncreasesQuality() {
        backstagePass.updateQuality();
        assertEquals(QUALITY + 1, backstagePass.quality);
    }

    @Test
    public void qualityIncreasesBy2When10DaysLeft() {
        setUp(10, 20);
        backstagePass.updateQuality();
        assertEquals(22, backstagePass.quality);
    }

    @Test
    public void qualityIncreasesBy3When5DaysLeft() {
        setUp(5, 20);
        backstagePass.updateQuality();
        assertEquals(23, backstagePass.quality);
    }

    @Test
    public void qualityDropsToZeroAfterConcert() {
        setUp(0, 20);
        backstagePass.updateQuality();
        assertEquals(0, backstagePass.quality);
    }

    @Test
    public void qualityisCapped() {
        setUp(5, MAX_QUALITY);
        backstagePass.updateQuality();
        assertEquals(MAX_QUALITY, backstagePass.quality);
    }
}
