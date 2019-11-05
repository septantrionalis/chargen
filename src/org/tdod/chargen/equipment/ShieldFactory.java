package org.tdod.chargen.equipment;

public enum ShieldFactory {

    NO_SHIELD("No Shield", 0),
    SHIELD("Shield", 1);
    
    private Shield shield = new Shield();

    private ShieldFactory(String name, int armorBonus) {
        shield.setName(name);
        shield.setArmorBonus(armorBonus);
    }

    public Shield getShield() {
        return shield;
    }
}
