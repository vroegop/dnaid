package dev.vroegop.dnaid.charactersheet.model;

public record AbilityScores(Integer strength, Integer dexterity, Integer intelligence,
                            Integer wisdom, Integer charisma, Integer constitution) {

    public static AbilityScores getDefaultInstance() {
        return new AbilityScores(0, 0, 0, 0, 0, 0);
    }
    Integer getByAbilityType(AbilityType type) {
        return switch(type) {
            case AbilityType.STRENGTH -> this.strength;
            case AbilityType.DEXTERITY -> this.dexterity;
            case AbilityType.WISDOM -> this.wisdom;
            case AbilityType.INTELLIGENCE -> this.intelligence;
            case AbilityType.CONSTITUTION -> this.constitution;
            case AbilityType.CHARISMA -> this.charisma;
            case AbilityType.NONE -> 0;
        };
    }


    public AbilityScores combine(AbilityScores other) {
        return new AbilityScores(
                this.strength + other.strength,
                this.dexterity + other.dexterity,
                this.intelligence + other.intelligence,
                this.wisdom + other.wisdom,
                this.charisma + other.charisma,
                this.constitution + other.constitution
        );
    }
}
