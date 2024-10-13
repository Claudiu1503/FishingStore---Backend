package com.backend.fishingstore.model;

public enum CategoryEnum {
    FISHING_RODS("Lansete"),
    REELS("Mulinete"),
    BAIT("Momeală"),
    LINE("Fire"),
    HOOKS("Cârlige"),
    WEIGHTS("Plumbi"),
    ACCESSORY_BOXES("Cutii pentru accesorii"),
    BUCKETS("Găleți"),
    OTHER_FISHING_EQUIPMENT("Alte echipamente"),
    TENTS("Corturi"),
    SLEEPING_BAGS("Saci de dormit"),
    BACKPACKS("Rucsaci"),
    COOKING_UTENSILS("Ustensile de gătit"),
    PORTABLE_GENERATORS("Generatoare portabile"),
    INFLATABLE_BEDS("Paturi gonflabile"),
    CAMPING_LAMPS("Lampi de camping"),
    FIRST_AID_KITS("Truse de prim ajutor"),
    CAMPING_FURNITURE("Mobilier de camping"),
    HYGIENE_PRODUCTS("Produse pentru igienă");

    private final String displayName;

    CategoryEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
