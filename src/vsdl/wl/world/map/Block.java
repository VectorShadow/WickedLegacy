package vsdl.wl.world.map;

public class Block {

    final static int SIZE = 64;

    Tile[][] tiles = new Tile[SIZE][SIZE];

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }
}
