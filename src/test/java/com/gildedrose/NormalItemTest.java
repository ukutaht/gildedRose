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
        setUp(SELL_IN, QUALITY);
    }

    public void setUp(int sellIn, int quality){
        normalItem = new Item("Item", sellIn, quality);
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
        setUp(10, 0);
        normalItem.updateQuality();

        assertEquals(0, normalItem.quality);
   }

    @Test
    public void itemQualityDegradesTwiceAsFastAfterSellByHasPassed() {
        setUp(0, 10);
        normalItem.updateQuality();

        assertEquals(8, normalItem.quality);
    }
}
