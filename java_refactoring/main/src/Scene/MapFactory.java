package Scene;

import Scene.Board;

import java.awt.*;

public class MapFactory {
    public static Board newSigleMap(int size){
        return new Board(new Dimension(size,size));
    }

}
