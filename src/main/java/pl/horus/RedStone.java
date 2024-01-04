package pl.horus;

public class RedStone implements Block {
    private static final String COLOR = "RED";
    private static final String MATERIAL = "STONE";
    @Override
    public String getColor() {
        return COLOR;
    }

    @Override
    public String getMaterial() {
        return MATERIAL;
    }

    @Override
    public String toString() {
        return "RedStone{" +
                "color='" + COLOR + '\'' +
                ", material='" + MATERIAL + '\'' +
                '}';
    }
}
