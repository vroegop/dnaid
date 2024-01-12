package dev.vroegop.dnaid.charactersheet;

import dev.vroegop.dnaid.charactersheet.model.CharacterSheet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CharacterRepository extends ReactiveMongoRepository<CharacterSheet, String> { }