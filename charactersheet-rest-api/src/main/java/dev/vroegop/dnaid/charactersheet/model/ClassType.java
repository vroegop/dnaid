package dev.vroegop.dnaid.charactersheet.model;

import lombok.Getter;

@Getter
public enum ClassType {
    BARBARIAN("Barbarian"),
    BARD("Bard"),
    CLERIC("Cleric"),
    DRUID("Druid"),
    FIGHTER("Fighter"),
    MONK("Monk"),
    PALADIN("Paladin"),
    RANGER("Ranger"),
    ROGUE("Rogue"),
    SORCERER("Sorcerer"),
    WARLOCK("Warlock"),
    WIZARD("Wizard");

    private final String name;

    ClassType(String name) {
        this.name = name;
    }
}