package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasTest {

    public static final int SELL_IN = 10;
    public static final int QUALITY = 80;
    private Item sulfuras;

    @Before
    public void setUp(){
        sulfuras = new Sulfuras(SELL_IN, QUALITY);
    }

    @Test
    public void updateQualityDoesNotDecrementSellIn() {
        sulfuras.updateQuality();
        assertEquals(SELL_IN, sulfuras.sellIn);
    }

    @Test
    public void updateQualityDoesNotChangeQuality() {
        sulfuras.updateQuality();
        assertEquals(QUALITY, sulfuras.quality);
    }


}
