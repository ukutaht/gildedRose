package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SulfurasTest {

    public static final int SELL_IN = 10;
    public static final int QUALITY = 80;
    private Item sulfuras;
    private List<Item> items;
    private GildedRose gildedRose;

    @Before
    public void setUp(){
        sulfuras = new Item("Sulfuras, Hand of Ragnaros", SELL_IN, QUALITY);
        items = Arrays.asList(sulfuras);
        gildedRose = new GildedRose(items);
    }

    @Test
    public void updateQualityDoesNotDecrementSellIn() {
        gildedRose.updateQuality();
        assertEquals(SELL_IN, sulfuras.sellIn);
    }

    @Test
    public void updateQualityDoesNotChangeQuality() {
        gildedRose.updateQuality();
        assertEquals(QUALITY, sulfuras.quality);
    }


}
