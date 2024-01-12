package dev.vroegop.dnaid.charactersheet.model;

import java.util.Collections;
import java.util.List;

public record Skills(
        Skill acrobatics,
        Skill animalHandling,
        Skill arcana,
        Skill athletics,
        Skill deception,
        Skill history,
        Skill insight,
        Skill intimidation,
        Skill investigation,
        Skill medicine,
        Skill nature,
        Skill perception,
        Skill performance,
        Skill persuasion,
        Skill religion,
        Skill sleightOfHand,
        Skill stealth,
        Skill survival
) {
    public static Skills getDefaultInstance() {
        return withProficiencies(Collections.emptyList());
    }

    public static Skills withProficiencies(List<SkillType> proficientSkills) {
        return new Skills(
                new Skill(null, proficientSkills.contains(SkillType.ACROBATICS)),
                new Skill(null, proficientSkills.contains(SkillType.ANIMAL_HANDLING)),
                new Skill(null, proficientSkills.contains(SkillType.ARCANA)),
                new Skill(null, proficientSkills.contains(SkillType.ATHLETICS)),
                new Skill(null, proficientSkills.contains(SkillType.DECEPTION)),
                new Skill(null, proficientSkills.contains(SkillType.HISTORY)),
                new Skill(null, proficientSkills.contains(SkillType.INSIGHT)),
                new Skill(null, proficientSkills.contains(SkillType.INTIMIDATION)),
                new Skill(null, proficientSkills.contains(SkillType.INVESTIGATION)),
                new Skill(null, proficientSkills.contains(SkillType.MEDICINE)),
                new Skill(null, proficientSkills.contains(SkillType.NATURE)),
                new Skill(null, proficientSkills.contains(SkillType.PERCEPTION)),
                new Skill(null, proficientSkills.contains(SkillType.PERFORMANCE)),
                new Skill(null, proficientSkills.contains(SkillType.PERSUASION)),
                new Skill(null, proficientSkills.contains(SkillType.RELIGION)),
                new Skill(null, proficientSkills.contains(SkillType.SLEIGHT_OF_HAND)),
                new Skill(null, proficientSkills.contains(SkillType.STEALTH)),
                new Skill(null, proficientSkills.contains(SkillType.SURVIVAL))
        );
    }

    public static Skills getSkillsWithAbilities(List<SkillType> proficientSkills) {
        return new Skills(
                new Skill(AbilityType.DEXTERITY, proficientSkills.contains(SkillType.ACROBATICS)),
                new Skill(AbilityType.WISDOM, proficientSkills.contains(SkillType.ANIMAL_HANDLING)),
                new Skill(AbilityType.INTELLIGENCE, proficientSkills.contains(SkillType.ARCANA)),
                new Skill(AbilityType.STRENGTH, proficientSkills.contains(SkillType.ATHLETICS)),
                new Skill(AbilityType.CHARISMA, proficientSkills.contains(SkillType.DECEPTION)),
                new Skill(AbilityType.INTELLIGENCE, proficientSkills.contains(SkillType.HISTORY)),
                new Skill(AbilityType.WISDOM, proficientSkills.contains(SkillType.INSIGHT)),
                new Skill(AbilityType.CHARISMA, proficientSkills.contains(SkillType.INTIMIDATION)),
                new Skill(AbilityType.INTELLIGENCE, proficientSkills.contains(SkillType.INVESTIGATION)),
                new Skill(AbilityType.WISDOM, proficientSkills.contains(SkillType.MEDICINE)),
                new Skill(AbilityType.INTELLIGENCE, proficientSkills.contains(SkillType.NATURE)),
                new Skill(AbilityType.WISDOM, proficientSkills.contains(SkillType.PERCEPTION)),
                new Skill(AbilityType.CHARISMA, proficientSkills.contains(SkillType.PERFORMANCE)),
                new Skill(AbilityType.CHARISMA, proficientSkills.contains(SkillType.PERSUASION)),
                new Skill(AbilityType.INTELLIGENCE, proficientSkills.contains(SkillType.RELIGION)),
                new Skill(AbilityType.DEXTERITY, proficientSkills.contains(SkillType.SLEIGHT_OF_HAND)),
                new Skill(AbilityType.DEXTERITY, proficientSkills.contains(SkillType.STEALTH)),
                new Skill(AbilityType.WISDOM, proficientSkills.contains(SkillType.SURVIVAL))
        );
    }

    public Skills combine(Skills other) {
        return new Skills(
                combineSkill(this.acrobatics, other.acrobatics),
                combineSkill(this.animalHandling, other.animalHandling),
                combineSkill(this.arcana, other.arcana),
                combineSkill(this.athletics, other.athletics),
                combineSkill(this.deception, other.deception),
                combineSkill(this.history, other.history),
                combineSkill(this.insight, other.insight),
                combineSkill(this.intimidation, other.intimidation),
                combineSkill(this.investigation, other.investigation),
                combineSkill(this.medicine, other.medicine),
                combineSkill(this.nature, other.nature),
                combineSkill(this.perception, other.perception),
                combineSkill(this.performance, other.performance),
                combineSkill(this.persuasion, other.persuasion),
                combineSkill(this.religion, other.religion),
                combineSkill(this.sleightOfHand, other.sleightOfHand),
                combineSkill(this.stealth, other.stealth),
                combineSkill(this.survival, other.survival)
        );
    }

    private Skill combineSkill(Skill skill1, Skill skill2) {
        return new Skill(skill1.ability() != null ? skill1.ability() : skill2.ability(), skill1.proficient() || skill2.proficient());
    }
}
