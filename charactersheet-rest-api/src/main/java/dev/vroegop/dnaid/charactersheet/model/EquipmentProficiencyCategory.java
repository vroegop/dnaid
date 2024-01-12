package dev.vroegop.dnaid.charactersheet.model;

import lombok.Getter;

@Getter
public enum EquipmentProficiencyCategory {
    LIGHT_ARMOR("Light Armor"),
    MEDIUM_ARMOR("Medium Armor"),
    SHIELD("Shield"),
    SIMPLE_WEAPON("Simple Weapon"),
    MARTIAL_WEAPON("Martial Weapon");

    private final String name;

    EquipmentProficiencyCategory(String name) {
        this.name = name;
    }
}
