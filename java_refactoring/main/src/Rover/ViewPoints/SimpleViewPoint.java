package Rover.ViewPoints;


import Rover.Heading;
import Rover.Position;

public class SimpleViewPoint implements Rover.ViewPoint {
    private Heading heading;
    private Position position;

    public SimpleViewPoint(String facing, int x, int y){
        this(Heading.of(facing),x,y);

    }
    public SimpleViewPoint(Heading heading, int x, int y){
        this.heading = heading;

    }
    public SimpleViewPoint(Heading heading, Position position){
        this.heading= heading;
        this.position = position;
    }
    public Heading heading(){
        return heading;
    }
    public Position position(){
        return position;
    }
    @Override
    public void turnLeft(){
        heading = heading.turnLeft();
    }
    @Override
    public void turnRight(){
        heading = heading.turnRight();
    }
    @Override
    public void forward(){
        position = position.forward(heading);
    }
    @Override
    public void backward(){
        position = position.backward(heading);
    }
}
