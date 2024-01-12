package dev.vroegop.dnaid.charactersheet.model;

import lombok.*;

import java.util.Collections;
import java.util.Set;

@Builder
public record CharacterModifier(
        AbilityScores abilityScoreIncreases,
        Skills skillProficiencies,
        SavingThrowProficiencies savingThrowProficiencies,
        SpellSlots spellSlots,
        Set<Spell> knownSpells,
        Set<EquipmentProficiencyCategory> equipmentProficiencies
) {
    public static CharacterModifier getDefaultInstance() {
        return new CharacterModifier(
                AbilityScores.getDefaultInstance(), // Add ability scores (is added to baseAbilityScore)
                Skills.getDefaultInstance(), // Add proficiencies (only true overrides, false is ignored)
                SavingThrowProficiencies.getDefaultInstance(), // Add proficiencies (only true overrides, false is ignored)
                SpellSlots.getDefaultInstance(), // Add or subtract spell slots if something provides or removes them
                Collections.emptySet(), // Add known spells to the character
                Collections.emptySet() // Add equipment proficiencies to the character
        );
    }
    public static CharacterModifier getClassInstance() {
        return new CharacterModifier(
                AbilityScores.getDefaultInstance(), // Add ability scores (is added to baseAbilityScore)
                Skills.getSkillsWithAbilities(Collections.emptyList()), // The class determines base abilities for skills, other modifiers can override this.
                SavingThrowProficiencies.getDefaultInstance(), // Add proficiencies (only true overrides, false is ignored)
                SpellSlots.getDefaultInstance(), // Add or subtract spell slots if something provides or removes them
                Collections.emptySet(), // Add known spells to the character
                Collections.emptySet() // Add equipment proficiencies to the character
        );
    }
}
