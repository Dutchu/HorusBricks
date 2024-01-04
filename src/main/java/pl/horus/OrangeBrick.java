package pl.horus;

public class OrangeBrick implements Block {
    private static final String COLOR = "ORANGE";
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
        return "OrangeBrick{" +
                "color='" + COLOR + '\'' +
                ", material='" + MATERIAL + '\'' +
                '}';
    }


}
