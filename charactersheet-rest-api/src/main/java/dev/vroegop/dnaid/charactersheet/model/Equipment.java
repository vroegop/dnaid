package dev.vroegop.dnaid.charactersheet.model;

import java.util.Collections;
import java.util.List;

public record Equipment(
        String name,
        List<EquipmentProficiencyCategory> categories,
        CharacterModifier modifiers
) {
    public static Equipment NoEquipment() {
        return new Equipment("None", Collections.emptyList(), CharacterModifier.getDefaultInstance());
    }
}