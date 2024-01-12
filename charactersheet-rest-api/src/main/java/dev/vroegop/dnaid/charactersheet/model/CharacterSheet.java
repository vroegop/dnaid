package dev.vroegop.dnaid.charactersheet.model;

import lombok.Builder;
import lombok.Data;
import reactor.core.publisher.Flux;

import java.util.*;
import java.util.stream.Stream;

/**
 * CharacterSheet gives all character information and calculates extra fields
 */
@Data
@Builder
public class CharacterSheet {
    private String id;
    private String name;
    private Integer level;
    private Integer xp;
    private Integer initiative;
    private CharacterRace characterRace;
    private CharacterClass characterClass;
    private Gender gender;
    private CharacterBackground characterBackground;
    private CharacterAlignment characterAlignment;
    private AbilityScores baseAbilityScores;
    private BodyEquipment body;
    private Backpack backpack;
    private HitPoints hitPoints;
    private List<PassiveEffect> activeEffects;

    public AbilityScores getAbilityScores() {
        return getModifiers()
                .map(CharacterModifier::abilityScoreIncreases)
                .reduce(AbilityScores.getDefaultInstance(), AbilityScores::combine);
    }

    public SavingThrowProficiencies getSavingThrowProficiencies() {
        return getModifiers()
                .map(CharacterModifier::savingThrowProficiencies)
                .reduce(SavingThrowProficiencies.getDefaultInstance(), SavingThrowProficiencies::combine);
    }

    public Skills getSkills() {
        return getModifiers()
                .map(CharacterModifier::skillProficiencies)
                .reduce(Skills.getDefaultInstance(), Skills::combine);
    }

    public SpellSlots getSpellSlots() {
        return getModifiers()
                .map(CharacterModifier::spellSlots)
                .reduce(SpellSlots.getDefaultInstance(), SpellSlots::combine);
    }

    public Set<Spell> getKnownSpells() {
        return getModifiers()
                .map(CharacterModifier::knownSpells)
                .reduce(new HashSet<>(), (known, spells) -> {
                    known.addAll(spells);
                    return known;
                });
    }

    public Set<EquipmentProficiencyCategory> getEquipmentProficiencies() {
        return getModifiers()
                .map(CharacterModifier::equipmentProficiencies)
                .reduce(new HashSet<>(), (known, proficiency) -> {
                    known.addAll(proficiency);
                    return known;
                });
    }

    public static CharacterSheet getDefaultInstance() {
        return builder()
                .name("Name")
                .level(1)
                .xp(0)
                .initiative(0)
                .characterRace(CharacterRace.getDefaultInstance())
                .characterClass(CharacterClass.getDefaultInstance())
                .gender(Math.random() > 0.5 ? Gender.MALE : Gender.FEMALE)
                .characterBackground(CharacterBackground.getDefaultInstance())
                .characterAlignment(CharacterAlignment.getDefaultInstance())
                .baseAbilityScores(AbilityScores.getDefaultInstance())
                .body(BodyEquipment.getDefaultInstance())
                .backpack(Backpack.getDefaultInstance())
                .hitPoints(HitPoints.getDefaultInstance())
                .activeEffects(Collections.emptyList())
                .build();
    }

    private Stream<CharacterModifier> getModifiers() {
        return Stream.of(
                characterClass.modifiers(),
                characterRace.modifiers(),
                characterBackground.modifiers(),
                characterAlignment.modifiers(),
                body.combinedModifiers()
        );
    }
}
