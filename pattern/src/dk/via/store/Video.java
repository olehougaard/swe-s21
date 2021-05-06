package dk.via.store;

import java.math.BigDecimal;

public class Video extends Item {
    public Video(BigDecimal price) {
        super(price);
    }

    @Override
    public String getItemText() {
        return "";
    }

    @Override
    public<T> T accept(ItemVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
