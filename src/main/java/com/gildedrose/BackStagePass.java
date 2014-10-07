package com.gildedrose;

public class BackStagePass extends Item {
    public BackStagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        sellIn--;
        int newQuality = quality;

        if (isBetween(sellIn, 5, 10)) {
            newQuality += 2;
        } else if (isBetween(sellIn, 0, 5)) {
            newQuality += 3;
        } else if (sellIn < 0) {
            newQuality = 0;
        } else {
            newQuality++;
        }

        quality = Math.min(newQuality, 50);
    }

    private boolean isBetween(int sellIn, int start, int end) {
        return start <= sellIn && sellIn < end;
    }
}
