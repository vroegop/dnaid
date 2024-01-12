package dev.vroegop.dnaid.charactersheet.model;

import lombok.Getter;

@Getter
public enum Background {
    ACOLYTE("Acolyte"),
    CHARLATAN("Charlatan"),
    CRIMINAL("Criminal"),
    ENTERTAINER("Entertainer"),
    FOLK_HERO("Folk Hero"),
    GUILD_ARTISAN("Guild Artisan"),
    HERMIT("Hermit"),
    NOBLE("Noble"),
    OUTLANDER("Outlander"),
    SAGE("Sage"),
    SAILOR("Sailor"),
    SOLDIER("Soldier"),
    URCHIN("Urchin");

    private final String name;

    Background(String name) {
        this.name = name;
    }

}

