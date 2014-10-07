package com.gildedrose;

public class Item {
    private String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality() {
        sellIn--;
        int newQuality = sellIn < 0 ? quality - 2 : quality - 1;
        quality = Math.max(newQuality, 0);
    }
}
