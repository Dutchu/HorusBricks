package pl.horus;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        Structure wall = Wall.getInstance();

        Block redBrick = new Brick("RED", "CLAY");
        Block yellowBrick = new Brick("YELLOW", "CLAY");
        Block redStone = new Brick("RED", "STONE");

        CompositeBricks compositeBrick = new CompositeBricks(List.of(redBrick, redStone));
        CompositeBricks yellowCompositeBrick = new CompositeBricks(List.of(yellowBrick));
        CompositeBricks compositeCompositeBrick = new CompositeBricks(List.of(compositeBrick, yellowCompositeBrick));

        wall.addBlock(redBrick);
        System.out.println(wall.count());
        wall.addBlock(compositeCompositeBrick, compositeBrick);
        System.out.println(wall.count());

        System.out.println("Optional search of one block by color");
        wall.findBlockByColor("YELLOW").ifPresent(System.out::println);

        System.out.println();

        System.out.println("Search of all blocks by material");
        wall.findBlocksByMaterial("CLAY").forEach(System.out::println);

        System.out.println();

        System.out.println("Search of all blocks by material=STONE");
        wall.findBlocksByMaterial("STONE").forEach(System.out::println);

        wall.removeBlock();
        System.out.println(wall.count());

    }
}
