package cn.xpbootcamp.gilded_rose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (isItemThatWillNeverDropInQuality(item)) {
                continue;
            }

            if (!isSpecialItem(item)) {
                item.reduceQuality();
            } else {
                increaseQualityIfLessThan50(item);

                if (isConcertHappeningInLessThan11Days(item)) {
                    increaseQualityIfLessThan50(item);

                    if (isConcertHappeningInLessThan6Days(item)) {
                        increaseQualityIfLessThan50(item);
                    }
                }
            }

            item.sell_in = item.sell_in - 1;

            if (itemHasExpired(item)) {
                switch (item.name) {
                    case "Aged Brie":
                        increaseQualityIfLessThan50(item);
                        break;
                    case "Backstage passes to a TAFKAL80ETC concert":
                        item.setToZero();
                        break;
                    default:
                        item.reduceQuality();
                        break;
                }
            }
        }
    }

    private boolean isSpecialItem(Item item) {
        return item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isItemThatWillNeverDropInQuality(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isConcertHappeningInLessThan11Days(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.sell_in < 11;
    }

    private boolean isConcertHappeningInLessThan6Days(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.sell_in < 6;
    }

    private boolean itemHasExpired(Item item) {
        return item.sell_in < 0;
    }

    private void increaseQualityIfLessThan50(Item item) {
        item.increaseQualityIfLessThan(50);
    }
}
