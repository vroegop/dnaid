package dev.vroegop.dnaid.charactersheet.model;

import lombok.Getter;

@Getter
public enum SkillType {
    ACROBATICS("Acrobatics"),
    ANIMAL_HANDLING("Animal Handling"),
    ARCANA("Arcana"),
    ATHLETICS("Athletics"),
    DECEPTION("Deception"),
    HISTORY("History"),
    INSIGHT("Insight"),
    INTIMIDATION("Intimidation"),
    INVESTIGATION("Investigation"),
    MEDICINE("Medicine"),
    NATURE("Nature"),
    PERCEPTION("Perception"),
    PERFORMANCE("Performance"),
    PERSUASION("Persuasion"),
    RELIGION("Religion"),
    SLEIGHT_OF_HAND("Sleight of Hand"),
    STEALTH("Stealth"),
    SURVIVAL("Survival");

    private final String name;

    SkillType(String name) {
        this.name = name;
    }

}
