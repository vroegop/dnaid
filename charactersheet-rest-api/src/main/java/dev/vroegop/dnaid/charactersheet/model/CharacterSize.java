package dev.vroegop.dnaid.charactersheet.model;

import lombok.Getter;

@Getter
public enum CharacterSize {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String name;

    CharacterSize(String name) {
        this.name = name;
    }
}
