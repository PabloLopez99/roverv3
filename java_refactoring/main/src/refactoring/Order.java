package refactoring;

import java.util.HashMap;
import java.util.Map;

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