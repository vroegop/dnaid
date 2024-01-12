package dev.vroegop.dnaid.charactersheet;

import dev.vroegop.dnaid.charactersheet.model.CharacterSheet;
import dev.vroegop.dnaid.charactersheet.model.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CharacterSheetService {
    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterSheetService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Mono<CharacterSheet> findById(String id) {
        return characterRepository.findById(id);
    }

    public Flux<CharacterSheet> findAll() {
        return characterRepository.findAll();
    }

    public Mono<Id> create(CharacterSheet sheet) {
        return characterRepository.save(sheet).map(data -> new Id(data.getId()));
    }
}