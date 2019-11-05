package org.tdod.chargen.player;

import java.util.ArrayList;
import java.util.List;

import org.tdod.chargen.equipment.Armor;
import org.tdod.chargen.equipment.Equipment;
import org.tdod.chargen.equipment.Shield;
import org.tdod.chargen.equipment.Weapon;

public class CharacterSheet {
    private AbilityScores abilityScores = new AbilityScores();
    private CharacterClass characterClass;
    private Alignment alignment;
    private List<Languages> languages = new ArrayList<Languages>();
    private int maxHp;
    private int gold;
    private Weapon weapon = null;
    private Armor armor = null;
    private Shield shield = null;
    private List<Equipment> equipment = new ArrayList<Equipment>();
    private SavingThrows savingThrows = new SavingThrows();
    private int level;
    
    public AbilityScores getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(AbilityScores abilityScores) {
        this.abilityScores = abilityScores;
    }
    
    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }
    
    public SavingThrows getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(SavingThrows savingThrows) {
        this.savingThrows = savingThrows;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getArmorClass() {
        return armor.getArmorClass() - shield.getArmorBonus() - AbilityScores.getBonus(abilityScores.getDexterity());
    }
    
    public int getThac0() {
        return 19;
    }
}
