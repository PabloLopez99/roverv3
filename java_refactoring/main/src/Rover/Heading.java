package Rover;

import java.util.HashMap;
import java.util.Map;

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