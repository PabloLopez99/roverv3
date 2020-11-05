package refactoring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static refactoring.Rover.Heading.*;
import static refactoring.Rover.Order.*;

public class Rover {

	private Heading heading;
	private Position position;
	Map<Order, Action> actions = new HashMap<>();

	public Rover(String facing, int x, int y) {
		this.heading = Heading.of(facing);
		position = new Position(x, y);
	}

	public Rover(Heading heading, Position position) {
		this.heading = heading;
		this.position = position;
	}

	public Rover(Heading heading, int x, int y) {
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

	public void go(String instructions){
		String[] instructionsList = instructions.split("");
		Arrays.stream(instructionsList)
				.filter(Order::isValidOrder)
				.forEach(c -> actions.get(Order.of(c)).execute());
	}

	public void go(Order... orders){
		for (Order order : orders) {
			actions.get(order).execute();
		}
	}

	public interface Action {
		void execute();
	}

	public static class Position {

		private final int x;

		private final int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		//TODO: Refactor
		public Position forward(Heading heading) {
			if (heading.isVertical()) return verticalMovement(heading, 1);
			return horizontalMovement(heading, 1);
		}

		public Position backward(Heading heading) {
			if (heading.isVertical()) return verticalMovement(heading, -1);
			return horizontalMovement(heading, -1);
		}

		//TODO: Refactorizar para que no tenga dos parametros
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

	public enum Order {
		Forward, Backward, Left, Right;
		static Map<Character, Order> orders = new HashMap<>();

		static {
			orders.put('R', Right);
			orders.put('L', Left);
			orders.put('F', Forward);
			orders.put('B', Backward);
		}

		public static Order of(String label) {
			return orders.get(label.charAt(0));
		}

		public static boolean isValidOrder (String label) {
			return orders.containsKey(label.charAt(0));
		}
	}

	public enum Heading {
		North, East, South, West;
		static Map<Character, Heading> headings = new HashMap<>();

		static {
			headings.put('N', North);
			headings.put('S', South);
			headings.put('W', West);
			headings.put('E', East);
		}

		public static Heading of(String label) {
			return of(label.charAt(0));
		}

		public static Heading of(char label) {
			return headings.get(label);
		}

		public boolean isVertical () { return this == North || this == South; }

		public Heading turnRight() {
			return values()[add(+1)];
		}

		public Heading turnLeft() {
			return values()[add(-1)];
		}

		private int add(int offset) {
			return (this.ordinal() + offset + values().length) % values().length;
		}
	}
}
