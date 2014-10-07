package com.gildedrose;

public class Conjured extends Item {
    public Conjured(int sellIn, int quality) {
        super("Conjured Mana Cake", sellIn, quality);
    }

    public void updateQuality() {
        sellIn--;
        int newQuality = sellIn < 0 ? quality - 4 : quality - 2;
        quality = Math.max(newQuality, 0);
    }
}
