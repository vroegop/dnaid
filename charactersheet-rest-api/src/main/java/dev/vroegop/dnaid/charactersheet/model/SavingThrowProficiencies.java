package dev.vroegop.dnaid.charactersheet.model;

public record SavingThrowProficiencies(Boolean strength, Boolean dexterity, Boolean intelligence,
                                       Boolean wisdom, Boolean charisma, Boolean constitution) {
    public static SavingThrowProficiencies getDefaultInstance() {
        return new SavingThrowProficiencies(false, false, false, false, false, false);
    }
    Boolean getByAbilityType(AbilityType type) {
        return switch (type) {
            case AbilityType.STRENGTH -> this.strength;
            case AbilityType.DEXTERITY -> this.dexterity;
            case AbilityType.WISDOM -> this.wisdom;
            case AbilityType.INTELLIGENCE -> this.intelligence;
            case AbilityType.CONSTITUTION -> this.constitution;
            case AbilityType.CHARISMA -> this.charisma;
            case AbilityType.NONE -> false;
        };
    }

    public SavingThrowProficiencies combine(SavingThrowProficiencies other) {
        return new SavingThrowProficiencies(
                this.strength || other.strength,
                this.dexterity || other.dexterity,
                this.intelligence || other.intelligence,
                this.wisdom || other.wisdom,
                this.charisma || other.charisma,
                this.constitution || other.constitution
        );
    }
}
