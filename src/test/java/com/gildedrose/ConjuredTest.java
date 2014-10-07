package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredTest {

    public static final int SELL_IN = 10;
    public static final int QUALITY = 15;
    private Item conjured;

    @Before
    public void setUp(){
        setUp(SELL_IN, QUALITY);
    }

    public void setUp(int sellIn, int quality){
        conjured = new Conjured(sellIn, quality);
    }

    @Test
    public void updateQualityDecrementsSellIn() {
        conjured.updateQuality();
        assertEquals(SELL_IN - 1, conjured.sellIn);
    }

    @Test
    public void updateQualityDecrementsQualityTwiceAsFast() {
        conjured.updateQuality();
        assertEquals(QUALITY - 2, conjured.quality);
    }

    @Test
    public void updateQualityDecrementsQualityEvenFasterAfterSellIn() {
        setUp(0, QUALITY);
        conjured.updateQuality();
        assertEquals(QUALITY - 4, conjured.quality);
    }

    @Test
    public void updateQualityDecrementsQualityNeverGoesBelowZero() {
        setUp(SELL_IN, 0);
        conjured.updateQuality();
        assertEquals(0, conjured.quality);
    }

}