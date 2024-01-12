package dev.vroegop.dnaid.charactersheet.model;

public record CharacterAlignment (AlignmentType name, CharacterModifier modifiers) {
    public static CharacterAlignment getDefaultInstance() {
        return new CharacterAlignment(AlignmentType.CHAOTIC_GOOD, CharacterModifier.getDefaultInstance());
    }
}
