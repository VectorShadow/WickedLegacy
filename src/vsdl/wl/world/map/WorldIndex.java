package vsdl.wl.world.map;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;

import static vsdl.wl.world.map.Block.SIZE;

public class WorldIndex {

    final ArrayList<RegionMap> MAPS = new ArrayList<>();

    RegionMap getMap(int idx){
        if (idx >= MAPS.size())
            throw new IllegalArgumentException("Index " + idx + " out of bounds [" + MAPS.size() + "].");
        return null;
    }
    Block getBlock(@NotNull RegionMap map, int x, int y){
        return map.getBlock(x, y);
    }
    Tile getTile(@NotNull RegionMap map, int blockX, int blockY, int tileX, int tileY) {
        return getBlock(map, blockX, blockY).getTile(tileX, tileY);
    }

    Point asMapCoordinate(int blockX, int blockY, int tileX, int tileY) {
        return new Point(SIZE * blockX + tileX, SIZE * blockY + tileY);
    }

    Point getBlockCoordinate(@NotNull Point mapCoordinate) {
        return new Point(mapCoordinate.x / SIZE, mapCoordinate.y / SIZE);
    }

    double getDistance(Point mapCoordinate1, Point mapCoordinate2) {
        int dx = mapCoordinate1.x - mapCoordinate2.x;
        int dy = mapCoordinate1.y - mapCoordinate2.y;
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    Point getTileCoordinate(@NotNull Point mapCoordinate) {
        return new Point(mapCoordinate.x % SIZE, mapCoordinate.y % SIZE);
    }

    Point shiftMapCoordinate(@NotNull Point sourceMapCoordinate, int dX, int dY) {
        return new Point(sourceMapCoordinate.x + dX, sourceMapCoordinate.y + dY);
    }

}
