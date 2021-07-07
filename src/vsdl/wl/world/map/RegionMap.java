package vsdl.wl.world.map;

public class RegionMap {
    Block[][] blocks;

    public Block getBlock(int x, int y) {
        return blocks[x][y];
    }
}
