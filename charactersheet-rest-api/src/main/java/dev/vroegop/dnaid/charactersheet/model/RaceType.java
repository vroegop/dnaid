package dev.vroegop.dnaid.charactersheet.model;

import lombok.Getter;

@Getter
public enum RaceType {
    DRAGONBORN("Dragonborn"),
    DWARF("Dwarf"),
    ELF("Elf"),
    GNOME("Gnome"),
    HALF_ELF("Half-Elf"),
    HALFLING("Halfling"),
    HALF_ORC("Half-Orc"),
    HUMAN("Human"),
    TIEFLING("Tiefling");

    private final String name;

    RaceType(String name) {
        this.name = name;
    }
}