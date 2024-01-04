package pl.horus;

import java.util.List;
import java.util.stream.Collectors;

public class Bricks implements CompositeBlock {
    private final List<Block> blocks;

    public Bricks(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String getColor() {
        return blocks.stream().map(Block::getColor).collect(Collectors.joining(","));
    }

    @Override
    public String getMaterial() {
        return blocks.stream().map(Block::getMaterial).collect(Collectors.joining(","));
    }

    @Override
    public String toString() {
        return "Bricks{" +
                "blocks=" + blocks +
                '}';
    }
}
