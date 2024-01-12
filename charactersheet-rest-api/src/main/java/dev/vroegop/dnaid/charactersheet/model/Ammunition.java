package dev.vroegop.dnaid.charactersheet.model;

public record Ammunition(Integer arrows) {
    public static Ammunition getDefaultInstance() {
        return new Ammunition(0);
    }
}
