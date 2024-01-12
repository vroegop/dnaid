package dev.vroegop.dnaid.charactersheet.model;

public record HitPoints(
        Integer maxHitPoints,
        Integer currentHitPoints,
        Integer temporaryHitPoints,
        Integer successDeathSaves,
        Integer failureDeathSaves,
        Integer hitDiceUsed) {

    public static HitPoints getDefaultInstance() {
        return new HitPoints(10, 10, 0, 0, 0, 0);
    }
}
