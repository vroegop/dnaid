package dev.vroegop.dnaid.charactersheet;

import dev.vroegop.dnaid.charactersheet.model.CharacterSheet;
import dev.vroegop.dnaid.charactersheet.model.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CharacterSheetController {
    private final CharacterSheetService characterSheetService;

    @Autowired
    public CharacterSheetController(CharacterSheetService characterSheetService) {
        this.characterSheetService = characterSheetService;
    }

    @GetMapping("/characterSheet/{id}")
    public Mono<CharacterSheet> characterSheetById(@PathVariable String id) {
        return characterSheetService.findById(id);
    }
    @GetMapping("/characterSheets")
    public Flux<CharacterSheet> characterSheets() {
        return characterSheetService.findAll();
    }

    @PostMapping("/createCharacterSheet")
    public Mono<Id> createCharacterSheet(@RequestBody CharacterSheet sheet) {
        return characterSheetService.create(sheet);
    }
}
