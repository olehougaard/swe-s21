package dk.via.store;

import java.math.BigDecimal;

public abstract class Item {
    private BigDecimal price;

    public Item(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public abstract String getItemText();

    public abstract<T> T accept(ItemVisitor<T> visitor);
}
