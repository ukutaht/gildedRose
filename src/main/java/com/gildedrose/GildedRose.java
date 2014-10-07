package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (isAgedBrie(item)) {
                updateAgedBrie(item);
            } else if(isSulfuras(item)) {
                updateSulfuras(item);
            }
            else if (isBackStagePass(item)) {
                updateBackstagePass(item);
            } else if (isNormalItem(item)) {
                updateNormalItem(item);
            } else {

                if (!item.name.equals("Aged Brie")
                        && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;

                        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (item.sellIn < 11) {
                                if (item.quality < 50) {
                                    item.quality = item.quality + 1;
                                }
                            }

                            if (item.sellIn < 6) {
                                if (item.quality < 50) {
                                    item.quality = item.quality + 1;
                                }
                            }
                        }
                    }
                }
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.sellIn = item.sellIn - 1;
                }

                if (item.sellIn < 0) {
                    if (!item.name.equals("Aged Brie")) {
                        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (item.quality > 0) {
                                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                    item.quality = item.quality - 1;
                                }
                            }
                        } else {
                            item.quality = item.quality - item.quality;
                        }
                    } else {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
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

    private boolean isNormalItem(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBetween(int sellIn, int start, int end) {
        return start <= sellIn && sellIn < end;
    }
}
