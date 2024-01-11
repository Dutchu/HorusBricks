package pl.horus;

import java.util.List;
import java.util.stream.Stream;

public class CompositeBricks implements CompositeBlock {

    private final List<Block> blocks;

    public CompositeBricks(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public String getColor() {
        return blocks.stream().flatMap(Block::getLeafs).map(Block::getColor).findAny().orElse(null);
    }

    @Override
    public String getMaterial() {
        return blocks.stream().flatMap(Block::getLeafs).map(Block::getMaterial).findAny().orElse(null);
    }

    @Override
    public Stream<Brick> getLeafs() {
        return blocks.stream().flatMap(Block::getLeafs);
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
