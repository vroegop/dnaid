package dev.vroegop.dnaid.charactersheet.model;

import lombok.Getter;

@Getter
public enum AbilityType {
    STRENGTH("Strength"),
    DEXTERITY("Dexterity"),
    INTELLIGENCE("Intelligence"),
    WISDOM("Wisdom"),
    CHARISMA("Charisma"),
    CONSTITUTION("Constitution"),
    NONE("None");

    private final String name;

    AbilityType(String name) {
        this.name = name;
    }

}