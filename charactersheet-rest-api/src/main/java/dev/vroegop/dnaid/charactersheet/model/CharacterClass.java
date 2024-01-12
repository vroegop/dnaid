package dev.vroegop.dnaid.charactersheet.model;

public record CharacterClass (
    ClassType name,
    Dice hitDice,
    CharacterModifier modifiers) {
    public static CharacterClass getDefaultInstance() {
        return new CharacterClass(ClassType.BARBARIAN, Dice.D8, CharacterModifier.getClassInstance());
    }
}
