package dev.vroegop.dnaid.charactersheet.model;


import java.util.Collections;
import java.util.List;

public record Backpack(
        int gold,
        int silver,
        int copper,
        List<Equipment> equipment,
        List<Consumable> consumables,
        List<Treasure> treasures,
        Ammunition ammunition
) {
    public static Backpack getDefaultInstance() {
        return new Backpack(
                10, 5, 10,
                Collections.emptyList(), // equipment
                Collections.emptyList(), // consumables
                Collections.emptyList(), // treasures
                Ammunition.getDefaultInstance()
        );
    }
}
