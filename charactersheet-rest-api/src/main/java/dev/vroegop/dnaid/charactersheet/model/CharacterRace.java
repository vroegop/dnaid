package dev.vroegop.dnaid.charactersheet.model;

import lombok.Builder;

@Builder
public record CharacterRace(
        RaceType name,
        Integer speed,
        CharacterSize size,
        CharacterModifier modifiers
) {
    public static CharacterRace getDefaultInstance() {
        return new CharacterRace(
                RaceType.HUMAN,
                30,
                CharacterSize.SMALL,
                CharacterModifier.getDefaultInstance()
        );
    }
}
