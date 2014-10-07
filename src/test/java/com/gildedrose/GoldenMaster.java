package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoldenMaster {

    @Test
    public void run() {
        String result = "";

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), // normal item
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 30;

        for (int i = 0; i < days; i++) {
            result += "-------- day " + i + " --------\n";
            result += "name, sellIn, quality";
            for (Item item : items) {
                result += item;
                result+= "\n";
            }
            result+= "\n";
            app.updateQuality();
        }

        assertEquals(GoldenOutput.theOutput, result);
    }
}
