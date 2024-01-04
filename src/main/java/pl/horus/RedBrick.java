package pl.horus;

public class RedBrick implements Block {
    private static final String COLOR = "RED";
    private static final String MATERIAL = "CLAY";

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
        return "RedBrick{" +
                "color='" + COLOR + '\'' +
                ", material='" + MATERIAL + '\'' +
                '}';
    }

}

