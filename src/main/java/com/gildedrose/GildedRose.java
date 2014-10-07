package com.gildedrose;

import java.util.List;

class GildedRose {
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isAgedBrie(item)) {
                updateAgedBrie(item);
            } else if (isSulfuras(item)) {
                updateSulfuras(item);
            } else if (isBackStagePass(item)) {
                updateBackstagePass(item);
            } else {
                updateNormalItem(item);
            }
        }
    }

    private void updateSulfuras(Item item) {
    }

    private boolean isSulfuras(Item item) {
      return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void updateBackstagePass(Item item) {
        item.sellIn--;
        int sellIn = item.sellIn;
        int newQuality = item.quality;


        if (isBetween(sellIn, 5, 10)) {
            newQuality += 2;
        } else if (isBetween(sellIn, 0, 5)) {
            newQuality += 3;
        } else if (sellIn < 0) {
            newQuality = 0;
        } else {
            newQuality++;
        }

        item.quality = Math.min(newQuality, 50);
    }

    private boolean isBackStagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateAgedBrie(Item item) {
        item.sellIn--;
        int newQuality = item.sellIn < 0 ? item.quality + 2 : item.quality + 1;
        item.quality = Math.min(newQuality, 50);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private void updateNormalItem(Item item) {
        item.sellIn--;
        int newQuality = item.sellIn < 0 ? item.quality - 2 : item.quality - 1;
        item.quality = Math.max(newQuality, 0);
    }

    private boolean isBetween(int sellIn, int start, int end) {
        return start <= sellIn && sellIn < end;
    }
}
