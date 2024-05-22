package cn.xpbootcamp.gilded_rose;

public class Item {

    public String name;

    public int sell_in;

    public int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    public void reduceQuality() {
        if (this.quality > 0) {
            this.quality--;
        }
    }
    public void increaseQualityIfLessThan(int threshold) {
        if (this.quality < threshold) {
            this.quality++;
        }
    }

    public void setToZero() {
        this.quality = 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }
}
