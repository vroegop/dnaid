package dev.vroegop.dnaid.charactersheet.model;

public record SpellSlots(Integer firstLevel, Integer secondLevel, Integer thirdLevel, Integer fourthLevel) {

    public static SpellSlots getDefaultInstance() {
        return new SpellSlots(0, 0, 0, 0);
    }

    public SpellSlots combine(SpellSlots other) {
        return new SpellSlots(
                this.firstLevel + other.firstLevel,
                this.secondLevel + other.secondLevel,
                this.thirdLevel + other.thirdLevel,
                this.fourthLevel + other.fourthLevel
        );
    }
}
