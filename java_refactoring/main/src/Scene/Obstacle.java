package Scene;

import java.awt.*;

public class Obstacle {

    boolean[][] map;

    public Obstacle(int squareSize) {
        map= new boolean[squareSize][squareSize];
    }
    public void addPart(Dimension dimension){
        this.map[dimension.width][dimension.width]=true;
    }

    public Dimension getDimension() {
        return new Dimension(map.length, map.length);
    }

    public boolean[][] getMap() {
        return map;
    }
}
