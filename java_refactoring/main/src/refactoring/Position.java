package refactoring;

import static refactoring.Heading.*;

public class Position {

    private final int x;

    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Position forward(Heading heading) {
        if (heading.isVertical()) return verticalMovement(heading, 1);
        return horizontalMovement(heading, 1);
    }

    public Position backward(Heading heading) {
        if (heading.isVertical()) return verticalMovement(heading, -1);
        return horizontalMovement(heading, -1);
    }

    private Position verticalMovement(Heading heading, int sign) {
        if (heading == North) return new Position(x, y + sign);
        return new Position(x, y - sign);
    }

    private Position horizontalMovement(Heading heading, int sign) {
        if (heading == East) return new Position(x + sign, y);
        return new Position(x - sign, y);
    }

    @Override
    public boolean equals(Object object) {
        return isSameClass(object) && equals((Position) object);
    }

    private boolean equals(Position position) {
        return position == this || (x == position.x && y == position.y);
    }

    private boolean isSameClass(Object object) {
        return object != null && object.getClass() == Position.class;
    }

}