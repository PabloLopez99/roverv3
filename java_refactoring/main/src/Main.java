import Rover.*;
import Scene.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
     //   Scene escena = new Scene(new Rover("N",0,0),new Board(new Dimension(100,100)));

        Board board= MapFactory.newSigleMap(50);
        board.generateRandomBoard();
        for (int i = 0; i < board.getBoard().length ; i++) {
            for (int j = 0; j <board.getBoard()[0].length ; j++) {
                if(board.getBoard()[i][j]!=null){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
            System.out.println("\n");
        }
    }

}
