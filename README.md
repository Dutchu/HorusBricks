Implementation of Composite Design Pattern.

interface Structure {

        //Searching by Leaf's property
        Optional<Block> findBlockByColor(String color);
        List<Block> findBlocksByMaterial(String material);
        
        //Count Leafs
        int count();
}

//Class with logic implementation 
public class Wall implements Structure {
        private List<Block> blocks;
}

interface Block {
        String getColor();
        String getMaterial();
        Steram<Block> getLeafs();
}

interface CompositeBlock extends Block {
        Stream<Brick> getLeafs()
}
