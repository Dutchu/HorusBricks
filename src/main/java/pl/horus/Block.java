package pl.horus;

import java.util.stream.Stream;

interface Block {
    String getColor();
    String getMaterial();
    Stream<Brick> getLeafs();
}