package pl.horus;

import java.util.*;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private final List<Block> blocks;
    private static Wall INSTANCE;

    private Wall() {
        blocks = new ArrayList<>();
    }

    public static Structure getInstance() throws IllegalStateException {
        //singleton implementation
        if (INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        } else {
            INSTANCE = new Wall();
            return INSTANCE;
        }
    }

    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .flatMap(Block::getLeafs)
                .filter(b -> b.getColor().equals(color))
                .map(e -> (Block) e)
                .findAny();
    }

    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .flatMap(Block::getLeafs)
                .filter(b -> b.getMaterial().equals(material))
                .map(e -> (Block) e)
                .collect(Collectors.toList());
    }

    public int count() {
        return Math.toIntExact(blocks.stream()
                .flatMap(Block::getLeafs)
                .count());
    }

    @Override
    public void addBlock(Block... block) {
        this.blocks.addAll(Arrays.asList(block));
        System.out.println("Block added");
    }

    @Override
    public void removeBlock() {
        blocks.remove(blocks.size() - 1);
        System.out.println("Removed block");
    }

}