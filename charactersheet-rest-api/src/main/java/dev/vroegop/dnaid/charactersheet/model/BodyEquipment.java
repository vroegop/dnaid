package dev.vroegop.dnaid.charactersheet.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record BodyEquipment(Equipment head, // Cosmetic helmets
                            Equipment shoulders,
                            Equipment chest,
                            Equipment toolset, // For things like toolsets
                            Equipment hands, // For things like gloves or braces
                            Equipment mainHand, // For main hand weapon
                            Equipment offHand, // For off-hand weapon or shield
                            Equipment legs,
                            Equipment feet,
                            Equipment back, // For cloaks or backpacks
                            Equipment armor, // For the armor class, the other armor items are cosmetic only
                            Equipment ring,
                            Equipment earrings,
                            Equipment necklace,
                            Equipment eyes // For items like goggles
) {

    public static BodyEquipment getDefaultInstance() {
        return new BodyEquipment(
                Equipment.NoEquipment(), // head
                Equipment.NoEquipment(), // shoulders
                Equipment.NoEquipment(), // chest
                Equipment.NoEquipment(), // waist
                Equipment.NoEquipment(), // hands
                Equipment.NoEquipment(), // mainHand
                Equipment.NoEquipment(), // offHand
                Equipment.NoEquipment(), // legs
                Equipment.NoEquipment(), // feet
                Equipment.NoEquipment(), // back
                Equipment.NoEquipment(), // armor
                Equipment.NoEquipment(), // ring
                Equipment.NoEquipment(), // earrings
                Equipment.NoEquipment(), // necklace
                Equipment.NoEquipment()  // eyes
        );
    }
    public Equipment getEquipmentByBodyPart(BodyPart bodyPart) {
        return switch (bodyPart) {
            case HEAD -> head;
            case SHOULDERS -> shoulders;
            case CHEST -> chest;
            case TOOLSET -> toolset;
            case HANDS -> hands;
            case MAIN_HAND -> mainHand;
            case OFF_HAND -> offHand;
            case LEGS -> legs;
            case FEET -> feet;
            case BACK -> back;
            case ARMOR -> armor;
            case RING -> ring;
            case EARRINGS -> earrings;
            case NECKLACE -> necklace;
            case EYES -> eyes;
        };
    }

    public CharacterModifier combinedModifiers() {
        List<Equipment> allEquipment = List.of(head, shoulders, chest, toolset, hands, mainHand, offHand, legs, feet, back, armor, ring, earrings, necklace, eyes);

        AbilityScores combinedAbilityScores = allEquipment.stream()
                .map(equipment -> equipment.modifiers().abilityScoreIncreases())
                .reduce(AbilityScores.getDefaultInstance(), AbilityScores::combine);

        Skills combinedSkills = allEquipment.stream()
                .map(equipment -> equipment.modifiers().skillProficiencies())
                .reduce(Skills.getDefaultInstance(), Skills::combine);

        SavingThrowProficiencies combinedSavingThrows = allEquipment.stream()
                .map(equipment -> equipment.modifiers().savingThrowProficiencies())
                .reduce(SavingThrowProficiencies.getDefaultInstance(), SavingThrowProficiencies::combine);

        SpellSlots combinedSpellSlots = allEquipment.stream()
                .map(equipment -> equipment.modifiers().spellSlots())
                .reduce(SpellSlots.getDefaultInstance(), SpellSlots::combine);

        Set<Spell> combinedSpells = allEquipment.stream()
                .flatMap(equipment -> equipment.modifiers().knownSpells().stream())
                .collect(Collectors.toSet());

        Set<EquipmentProficiencyCategory> combinedEquipmentProficiencies = allEquipment.stream()
                .flatMap(equipment -> equipment.modifiers().equipmentProficiencies().stream())
                .collect(Collectors.toSet());

        return new CharacterModifier(combinedAbilityScores, combinedSkills, combinedSavingThrows, combinedSpellSlots, combinedSpells, combinedEquipmentProficiencies);
    }
}
