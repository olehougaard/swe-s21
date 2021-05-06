package dk.via.store;

import java.math.BigDecimal;

public class Music extends Item {
    private final int id;
    private final String artist;
    private final String songTitle;
    private final int length;

    public Music(BigDecimal price, int id, String artist, String songTitle, int length) {
        super(price);
        this.id = id;
        this.artist = artist;
        this.songTitle = songTitle;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getItemText() {
        return songTitle;
    }

    @Override
    public<T> T accept(ItemVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
