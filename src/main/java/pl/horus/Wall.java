package pl.horus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


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
        Optional<Block> result;
        result = blocks.stream().filter(block -> block.getColor().equals(color)).findFirst();
        return result;
    }

    public List<Block> findBlocksByMaterial(String material) {
        List<Block> result = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                result.add(block);
            }
            if (block instanceof CompositeBlock) {
                result.addAll(findBlocksByMaterialInComposite((CompositeBlock) block, material));
            }
        }
        return result;
    }

    private List<Block> findBlocksByMaterialInComposite(CompositeBlock composite, String material) {
        List<Block> result = new ArrayList<>();
        for (Block block : composite.getBlocks()) {
            if (block.getMaterial().equals(material)) {
                result.add(block);
            }
            if (block instanceof CompositeBlock) {
                result.addAll(findBlocksByMaterialInComposite((CompositeBlock) block, material));
            }
        }
        return result;
    }

    public int count() {
        return blocks.stream()
                .mapToInt(e -> e instanceof CompositeBlock ? ((CompositeBlock) e).getBlocks().size() : 1)
                .sum();
    }

    @Override
    public void addBlock() {
        blocks.add(new RedBrick());
        System.out.println("Added block");
    }

    @Override
    public void addCompositeBlock() {
        blocks.add(
                new Bricks(Arrays.asList(
                    new RedBrick(),
                    new RedStone(),
                    new OrangeBrick()
                    ))
        );
        System.out.println("Added composite block");
    }

    @Override
    public void removeBlock() {
        blocks.remove(blocks.size() - 1);
        System.out.println("Removed block");
    }


    @Override
    public void addBlocks() {
        blocks.add(new RedBrick());
        blocks.add(new OrangeBrick());
        blocks.add(new RedStone());
    }
}