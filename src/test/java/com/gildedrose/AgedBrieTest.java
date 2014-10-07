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
        agedBrie = new AgedBrie(SELL_IN, QUALITY);
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
        for (int i = 0; i < SELL_IN + 1; i++) {
            agedBrie.updateQuality();
        }

        assertEquals(SELL_IN + QUALITY + 2, agedBrie.quality);
    }

    @Test
    public void qualityisCapped() {
        for (int i = 0; i < MAX_QUALITY; i++) {
            agedBrie.updateQuality();
        }
        assertEquals(MAX_QUALITY, agedBrie.quality);
    }
}
