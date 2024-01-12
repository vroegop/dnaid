package dev.vroegop.dnaid.charactersheet.model;

public record CharacterBackground (BackgroundType name, CharacterModifier modifiers) {
    public static CharacterBackground getDefaultInstance() {
        return new CharacterBackground(BackgroundType.FOLK_HERO, CharacterModifier.getDefaultInstance());
    }
}
