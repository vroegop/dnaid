package dev.vroegop.dnaid.charactersheet.model;

import lombok.Getter;

@Getter
public enum BodyPart {
    HEAD("Head"), // Cosmetic helmets
    SHOULDERS("Shoulders"),
    CHEST("Chest"),
    TOOLSET("Toolset"), // for things like Toolsets
    HANDS("Hands"), // for things like gloves or braces
    MAIN_HAND("Main Hand"), // for main hand weapon
    OFF_HAND("Off Hand"), // for off-hand weapon or shield
    LEGS("Legs"),
    FEET("Feet"),
    BACK("Back"), // for cloaks or backpacks
    ARMOR("Armor"), // For the armor class, the other armor items are cosmetic only
    RING("Ring"),
    EARRINGS("Earrings"),
    NECKLACE("Necklace"),
    EYES("Eyes"); // for items like goggles

    private final String name;

    BodyPart(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
