package refactoring;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static refactoring.Order.*;


public class Rover2 {

    private Heading heading;
    private Position position;
    Map<Order, Action> actions = new HashMap<>();

    public Rover2(String facing, int x, int y) {
        this.heading = Heading.of(facing);
        position = new Position(x, y);
    }

    public Rover2(Heading heading, Position position) {
        this.heading = heading;
        this.position = position;
    }

    public Rover2(Heading heading, int x, int y) {
        this.heading = heading;
        position = new Position(x, y);
    }

    {
        actions.put(Forward, () -> position = position.forward(heading));
        actions.put(Backward, () -> position = position.backward(heading));
        actions.put(Left, () -> heading = heading.turnLeft());
        actions.put(Right, () -> heading = heading.turnRight());
    }

    public Heading heading() {
        return heading;
    }

    public Position position() {
        return position;
    }

    public void go(String instructions) {
        String[] instructionsList = instructions.split("");
        Arrays.stream(instructionsList)
                .filter(Order::isValidOrder)
                .forEach(c -> actions.get(Order.of(c)).execute());
    }

    public void go(Order... orders) {
        for (Order order : orders) {
            actions.get(order).execute();
        }
    }

    public interface Action {
        void execute();
    }
}
