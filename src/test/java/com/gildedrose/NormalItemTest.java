package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalItemTest {

    public static final int SELL_IN = 10;
    public static final int QUALITY = 15;
    private Item normalItem;


    @Before
    public void setUp(){
        normalItem = new Item("foo", SELL_IN, QUALITY);
    }

    @Test
    public void updateQualityDecrementsSellIn() {
        normalItem.updateQuality();
        assertEquals(SELL_IN - 1, normalItem.sellIn);
    }

    @Test
    public void updateQualityDecrementsQuality() {
        normalItem.updateQuality();
        assertEquals(QUALITY - 1, normalItem.quality);
    }

    @Test
    public void itemQualityDoesNotGoBelowZero() {
        for (int i = 0; i < QUALITY + 2; i++) {
            normalItem.updateQuality();
        }

        assertEquals(0, normalItem.quality);
   }

    @Test
    public void itemQualityDegradesTwiceAsFastAfterSellByHasPassed() {
        for (int i = 0; i < SELL_IN + 1; i++) {
            normalItem.updateQuality();
        }

        assertEquals(QUALITY - SELL_IN - 2, normalItem.quality);
    }
}
