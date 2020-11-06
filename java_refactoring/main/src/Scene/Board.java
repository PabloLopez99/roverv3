package Scene;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Board {

    Casilla[][] tablero;


    Dimension dimension;
    public Board(Dimension dimension) {
        tablero = new Casilla[dimension.width][dimension.height];

    }
    public void generateRandomBoard(){

    int min= tablero.length/7;
    int max= tablero.length/5;


        for (int i = 0; i < new Random().nextInt((max-min)-1)+min; i++) {
           Obstacle ob= new Obstacle( new Random().nextInt(4-2));
            for (int j = 0; j <ob.getDimension().width ; j++) {
                for (int k = 0; k < ob.getDimension().height ; k++) {

                    if(new Random().nextInt(11)>new Random().nextInt(6)){

                        ob.addPart(new Dimension(j,k));
                        tablero[j][k]=new Casilla(ob);
                        System.out.println("aaa");
                    }

                }
            }

        }
    }
    public boolean addObstacle(Obstacle obstacle, Dimension ubicacion){
        for (int i = ubicacion.width; i < obstacle.getDimension().width+ubicacion.width; i++) {
            for (int j = ubicacion.height; j < obstacle.getDimension().height+ubicacion.height; j++) {
                if(tablero[i][j]!=null){
                    return false;
                }else{
                    if(obstacle.getMap()[i- ubicacion.width][j- ubicacion.height]){
                        tablero[i][j]= new Casilla(obstacle);
                    }
                }
            }
        }
        return true;
    }
    public boolean[][] reveal(Dimension position, int ratio){
        boolean[][] rev = new boolean[(ratio*2)+1][(ratio*2)+1];
        for (int i = position.width-ratio; i < position.width+ratio; i++) {
            for (int j = position.height-ratio; j < position.height+ratio; j++) {
                if(tablero[i][j]!=null){
                    rev[i][j]=true;
                }
            }
        }
        return rev;
    }
    public Casilla[][] getBoard(){
        return tablero;
    }

}
