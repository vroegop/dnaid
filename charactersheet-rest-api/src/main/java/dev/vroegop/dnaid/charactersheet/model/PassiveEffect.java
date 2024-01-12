package dev.vroegop.dnaid.charactersheet.model;

import java.util.List;

public record PassiveEffect(
        String name,
        List<EquipmentProficiencyCategory> categories,
        CharacterModifier modifiers
) {
}