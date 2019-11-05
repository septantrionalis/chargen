package org.tdod.chargen.equipment;

public enum ArmorFactory {

    NO_ARMOR("No Armor", 9),
    LEATHER_ARMOR("Leather Armor", 7),
    SCALE_ARMOR("Scale Armor", 6),
    CHAIN_MAIL("Chain Mail", 5),
    BANDED_ARMOR("Banded Armor", 4),
    PLATE_MAIL("Plate Mail", 3),
    SUIT_ARMOR("Suit Armor", 0);

    private Armor armor = new Armor();
    
    private ArmorFactory(String name, int armorClass) {
        armor.setName(name);
        armor.setArmorClass(armorClass);
    }
    
    public Armor getArmor() {
        return armor;
    }

}
