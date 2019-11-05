package org.tdod.chargen.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tdod.chargen.utils.Dice;

public enum CharacterClass {
    CLERIC("Cleric"),
    FIGHTER("Fighter"),
    MAGIC_USER("Magic-User"),
    THIEF("Thief"),
    DWARF("Dwarf"),
    ELF("Elf"),
    HALFLING("Halfling"),
    DRUID("Druid"),
    MYSTIC("Mystic");
    
    private String displayName;
    private List<AbilityScoreEnum> primeRequisites = new ArrayList<AbilityScoreEnum>();
    private Map<AbilityScoreEnum, Integer> minimumStats = new HashMap<AbilityScoreEnum, Integer>();
    private List<Alignment> invalidAlignments = new ArrayList<Alignment>();
    private Dice hpDice;
    private List<Languages> languages = new ArrayList<Languages>();
    
    private CharacterClass(String displayName) {
        this.displayName = displayName;
        
        if ("Cleric".equals(displayName)) {
            primeRequisites.add(AbilityScoreEnum.WISDOM);
            hpDice = Dice.D6;
            languages.add(Languages.COMMON);
        } else if ("Fighter".equals(displayName)) {
            primeRequisites.add(AbilityScoreEnum.STRENGTH);            
            hpDice = Dice.D8;
            languages.add(Languages.COMMON);
        } else if ("Thief".equals(displayName)) {
            primeRequisites.add(AbilityScoreEnum.DEXTERITY);
            hpDice = Dice.D4;
            languages.add(Languages.COMMON);
        } else if ("Magic-User".equals(displayName)) {
            primeRequisites.add(AbilityScoreEnum.INTELLIGENCE);
            hpDice = Dice.D4;
            languages.add(Languages.COMMON);
        } else if ("Elf".equals(displayName)) {
            primeRequisites.add(AbilityScoreEnum.STRENGTH);
            primeRequisites.add(AbilityScoreEnum.INTELLIGENCE);
            minimumStats.put(AbilityScoreEnum.INTELLIGENCE, 9);
            hpDice = Dice.D6;
            languages.add(Languages.COMMON);
            languages.add(Languages.ELF);
            languages.add(Languages.GNOLL);
            languages.add(Languages.HOBGOBLIN);
            languages.add(Languages.ORC);
        } else if ("Halfling".equals(displayName)) {
            primeRequisites.add(AbilityScoreEnum.STRENGTH);
            primeRequisites.add(AbilityScoreEnum.DEXTERITY);
            minimumStats.put(AbilityScoreEnum.CONSTITUTION, 9);
            minimumStats.put(AbilityScoreEnum.DEXTERITY, 9);
            hpDice = Dice.D6;
            languages.add(Languages.COMMON);
        } else if ("Dwarf".equals(displayName)) {
            primeRequisites.add(AbilityScoreEnum.STRENGTH);            
            minimumStats.put(AbilityScoreEnum.CONSTITUTION, 9);
            hpDice = Dice.D8;
            languages.add(Languages.COMMON);
            languages.add(Languages.DWARF);
            languages.add(Languages.GNOLL);
            languages.add(Languages.GOBLIN);
            languages.add(Languages.KOBOLD);
        } else if ("Druid".equals(displayName)) {
            primeRequisites.add(AbilityScoreEnum.WISDOM);   
            invalidAlignments.add(Alignment.LAW);
            invalidAlignments.add(Alignment.CHAOS);
            languages.add(Languages.COMMON);
        } else if ("Mystic".equals(displayName)) {
            primeRequisites.add(AbilityScoreEnum.STRENGTH);   
            primeRequisites.add(AbilityScoreEnum.DEXTERITY);   
            minimumStats.put(AbilityScoreEnum.WISDOM, 13);
            minimumStats.put(AbilityScoreEnum.DEXTERITY, 13);
        }
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public List<AbilityScoreEnum> getPrimeRequisites() {
        return primeRequisites;
    }
    
    public Map<AbilityScoreEnum, Integer> getMinimumStats() {
        return minimumStats;
    }
    
    public Dice getHpDice() {
        return hpDice;
    }
    
    public List<Languages> getLanguages() {
        return languages;
    }

    public List<Alignment> getInvalidAlignments() {
        return invalidAlignments;
    }
    
}
