package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }


    public void updateQuality() {
        sellIn--;
        int newQuality = sellIn < 0 ? quality + 2 : quality + 1;
        quality = Math.min(newQuality, 50);
    }
}
