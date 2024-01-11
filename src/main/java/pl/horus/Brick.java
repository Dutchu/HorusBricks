package pl.horus;

import java.util.stream.Stream;

public class Brick implements Block {
    private final String color;
    private final String material;

    public Brick(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public Stream<Brick> getLeafs() {
        return Stream.of(this);
    }


    @Override
    public String toString() {
        return "Brick{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }


}
