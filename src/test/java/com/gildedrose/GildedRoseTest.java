package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    public static final int SELL_IN = 10;
    public static final int QUALITY = 15;
    private Item normalItem;
    private List<Item> items;
    private GildedRose gildedRose;


    @Before
    public void setUp(){
        normalItem = new Item("foo", SELL_IN, QUALITY);
        items = Arrays.asList(normalItem);
        gildedRose = new GildedRose(items.toArray(new Item[0]));
    }

    @Test
    public void updateQualityDecrementsSellIn() {
        gildedRose.updateQuality();
        assertEquals(SELL_IN - 1, normalItem.sellIn);
    }

    @Test
    public void updateQualityDecrementsQuality() {
        gildedRose.updateQuality();
        assertEquals(QUALITY - 1, normalItem.quality);
    }

    @Test
    public void itemQualityDoesNotGoBelowZero() {
        for (int i = 0; i < QUALITY + 2; i++) {
            gildedRose.updateQuality();
        }

        assertEquals(0, normalItem.quality);
    }
}
