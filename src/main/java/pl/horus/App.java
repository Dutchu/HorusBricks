package pl.horus;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        Structure wall = Wall.getInstance();
        wall.addBlock();
        wall.addBlocks();
        wall.addCompositeBlock();
        System.out.println(wall.count());

        System.out.println("Optional search of one block by color");
        wall.findBlockByColor("RED").ifPresent(System.out::println);
        System.out.println("Search of all blocks by material");
        wall.findBlocksByMaterial("CLAY").forEach(System.out::println);

        wall.removeBlock();
        System.out.println(wall.count());

    }
}
