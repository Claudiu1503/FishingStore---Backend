package com.backend.fishingstore.model;

import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "categoriesEnum")
public enum CategoryEnum {
    FISHING_RODS("Lansete"),
    REELS("Mulinete"),
    BAIT("Momeala"),
    LINE("Fire"),
    HOOKS("Carlige"),
    WEIGHTS("Plumbi"),
    ACCESSORY_BOXES("Cutii pentru accesorii"),
    BUCKETS("Galeti"),
    OTHER_FISHING_EQUIPMENT("Alte echipamente"),
    TENTS("Corturi"),
    SLEEPING_BAGS("Saci de dormit"),
    BACKPACKS("Rucsaci"),
    COOKING_UTENSILS("Ustensile de gatit"),
    PORTABLE_GENERATORS("Generatoare portabile"),
    INFLATABLE_BEDS("Paturi gonflabile"),
    CAMPING_LAMPS("Lampi de camping"),
    FIRST_AID_KITS("Truse de prim ajutor"),
    CAMPING_FURNITURE("Mobilier de camping"),
    HYGIENE_PRODUCTS("Produse pentru igiena");

    private final String displayName;

    CategoryEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
