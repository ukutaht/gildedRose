package com.agedBrie;

import com.gildedrose.AgedBrie;
import com.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    public static final int SELL_IN = 10;
    public static final int QUALITY = 15;
    private Item agedBrie;
    private static int MAX_QUALITY = 50;

    @Before
    public void setUp(){
        setUp(SELL_IN, QUALITY);
    }

    public void setUp(int sellIn, int quality){
        agedBrie = new AgedBrie(sellIn, quality);
    }

    @Test
    public void updateQualityDecrementsSellIn() {
        agedBrie.updateQuality();
        assertEquals(SELL_IN - 1, agedBrie.sellIn);
    }

    @Test
    public void updateQualityIncreasesQuality() {
        agedBrie.updateQuality();
        assertEquals(QUALITY + 1, agedBrie.quality);
    }

    @Test
    public void qualityIncreasesTwiceAsFastAfterSellIn() {
        setUp(0, 10);
        agedBrie.updateQuality();

        assertEquals(12, agedBrie.quality);
    }

    @Test
    public void qualityIsCapped() {
        setUp(10, MAX_QUALITY);
        agedBrie.updateQuality();

        assertEquals(MAX_QUALITY, agedBrie.quality);
    }
}
