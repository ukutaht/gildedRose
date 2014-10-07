package com.gildedrose;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GoldenMaster {

    @Test
    public void run() {
        String result = "";

        List<Item> items = Arrays.asList(
                new Item("+5 Dexterity Vest", 10, 20), // normal item
                new AgedBrie(2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Sulfuras(0, 80), //
                new Sulfuras(-1, 80),
                new BackStagePass(15, 20),
                new BackStagePass(10, 49),
                new BackStagePass(5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6));

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
