package dev.vroegop.dnaid.charactersheet.model.helpers;

import dev.vroegop.dnaid.charactersheet.model.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CharacterSheetHelper {

    public static AbilityScores allAbilitiesPlusOne() {
        return new AbilityScores(1, 1, 1, 1, 1, 1);
    }

    public static Equipment equipmentWithPlusOneAbilities() {
        return new Equipment("PlusOne", Collections.emptyList(), new CharacterModifier(
                allAbilitiesPlusOne(),
                Skills.getDefaultInstance(),
                SavingThrowProficiencies.getDefaultInstance(), 
                SpellSlots.getDefaultInstance(), 
                Collections.emptySet(),
                Collections.emptySet()
        ));
    }

    public static CharacterRace humanRace() {
        return new CharacterRace(
                RaceType.HUMAN,
                30,
                CharacterSize.MEDIUM,
                new CharacterModifier(
                        allAbilitiesPlusOne(),
                        Skills.withProficiencies(List.of(SkillType.ACROBATICS)),
                        SavingThrowProficiencies.getDefaultInstance(),
                        SpellSlots.getDefaultInstance(),
                        Collections.emptySet(),
                        Collections.emptySet()
                )
        );
    }

    public static CharacterClass barbarianClass() {
        return new CharacterClass(
                ClassType.BARBARIAN,
                Dice.D12,
                new CharacterModifier(
                        AbilityScores.getDefaultInstance(),
                        Skills.getSkillsWithAbilities(List.of(SkillType.ATHLETICS, SkillType.NATURE)),
                        new SavingThrowProficiencies(true, false, false, false, false, true),
                        SpellSlots.getDefaultInstance(),
                        Collections.emptySet(),
                        Set.of(
                                EquipmentProficiencyCategory.SIMPLE_WEAPON,
                                EquipmentProficiencyCategory.MARTIAL_WEAPON,
                                EquipmentProficiencyCategory.LIGHT_ARMOR,
                                EquipmentProficiencyCategory.MEDIUM_ARMOR,
                                EquipmentProficiencyCategory.SHIELD
                        )
                )
        );
    }
}
