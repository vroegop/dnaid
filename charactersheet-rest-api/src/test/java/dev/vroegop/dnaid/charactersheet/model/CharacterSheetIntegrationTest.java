package dev.vroegop.dnaid.charactersheet.model;

import dev.vroegop.dnaid.charactersheet.CharacterSheetController;
import dev.vroegop.dnaid.charactersheet.model.helpers.CharacterSheetHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class CharacterSheetIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private CharacterSheetController characterSheetController;

    private CharacterSheet sheet;

    @BeforeEach
    public void before() {
        sheet = CharacterSheet.getDefaultInstance();
    }

    @Test
    void testCreateCharacterSheet() {
        webTestClient.post().uri("/createCharacterSheet")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(sheet)
                .exchange()
                .expectStatus().isOk()
                .expectBody(CharacterSheet.class)
                .consumeWith(response -> {
                    assertNotNull(response.getResponseBody());
                    assertNotNull(response.getResponseBody().getId());
                });
    }

    @Test
    void testGetCharacterSheetById() {
        Mono<Id> sheetId = characterSheetController.createCharacterSheet(sheet);

        webTestClient.get().uri("/characterSheet/{id}", sheetId.block().id())
                .exchange()
                .expectStatus().isOk()
                .expectBody(CharacterSheet.class)
                .consumeWith(response -> {
                    assertNotNull(response.getResponseBody());
                    assertEquals(sheet.getName(), response.getResponseBody().getName());
                    assertEquals(sheet.getBaseAbilityScores(), response.getResponseBody().getAbilityScores());
                });
    }

    @Test
    void testGetCharacterSheetWithEquipmentModifiers() {
        BodyEquipment body = new BodyEquipment(
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities(),
                CharacterSheetHelper.equipmentWithPlusOneAbilities()
        );
        sheet.setBody(body);
        Mono<Id> sheetId = characterSheetController.createCharacterSheet(sheet);

        webTestClient.get().uri("/characterSheet/{id}", sheetId.block().id())
                .exchange()
                .expectStatus().isOk()
                .expectBody(CharacterSheet.class)
                .consumeWith(response -> {
                    assertNotNull(response.getResponseBody());
                    assertEquals(sheet.getName(), response.getResponseBody().getName());
                    assertEquals(new AbilityScores(15, 15, 15, 15, 15, 15), response.getResponseBody().getAbilityScores());
                });
    }

    @Test
    void testGetCharacterSheetWithAbilityModifiers() {
        CharacterRace race = CharacterSheetHelper.humanRace();
        sheet.setCharacterRace(race);
        Mono<Id> sheetId = characterSheetController.createCharacterSheet(sheet);

        webTestClient.get().uri("/characterSheet/{id}", sheetId.block().id())
                .exchange()
                .expectStatus().isOk()
                .expectBody(CharacterSheet.class)
                .consumeWith(response -> {
                    assertNotNull(response.getResponseBody());
                    assertEquals(sheet.getName(), response.getResponseBody().getName());
                    assertEquals(new AbilityScores(1, 1, 1, 1, 1, 1), response.getResponseBody().getAbilityScores());
                    assertEquals(new Skill(AbilityType.DEXTERITY, true), response.getResponseBody().getSkills().acrobatics());
                });
    }

    @Test
    void testGetCharacterSheetWithSavingThrowAndEquipmentCategoryModifiers() {
        CharacterClass characterClass = CharacterSheetHelper.barbarianClass();
        sheet.setCharacterClass(characterClass);
        Mono<Id> sheetId = characterSheetController.createCharacterSheet(sheet);

        webTestClient.get().uri("/characterSheet/{id}", sheetId.block().id())
                .exchange()
                .expectStatus().isOk()
                .expectBody(CharacterSheet.class)
                .consumeWith(response -> {
                    assertNotNull(response.getResponseBody());
                    assertEquals(sheet.getName(), response.getResponseBody().getName());
                    assertEquals(new AbilityScores(0, 0, 0, 0, 0, 0), response.getResponseBody().getAbilityScores());
                    assertEquals(new Skill(AbilityType.INTELLIGENCE, true), response.getResponseBody().getSkills().nature());
                    assertEquals(new Skill(AbilityType.STRENGTH, true), response.getResponseBody().getSkills().athletics());
                    assertEquals(Set.of(
                            EquipmentProficiencyCategory.SIMPLE_WEAPON,
                            EquipmentProficiencyCategory.MARTIAL_WEAPON,
                            EquipmentProficiencyCategory.LIGHT_ARMOR,
                            EquipmentProficiencyCategory.MEDIUM_ARMOR,
                            EquipmentProficiencyCategory.SHIELD
                    ), response.getResponseBody().getEquipmentProficiencies());
                });
    }
}
