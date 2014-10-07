package com.gildedrose;

import java.util.List;

class GildedRose {
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isBackStagePass(item)) {
                updateBackstagePass(item);
            } else {
                item.updateQuality();
            }
        }
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

    private boolean isBetween(int sellIn, int start, int end) {
        return start <= sellIn && sellIn < end;
    }
}
