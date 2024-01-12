package dev.vroegop.dnaid.charactersheet.model;

public enum Dice {
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20),
    PERCENTILE(100); // Often represented as D100 or two D10s for percentile rolls

    private final int sides;

    Dice(int sides) {
        this.sides = sides;
    }

    public int getSides() {
        return sides;
    }

    @Override
    public String toString() {
        return "D" + sides;
    }
}
