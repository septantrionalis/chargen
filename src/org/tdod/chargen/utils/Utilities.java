package org.tdod.chargen.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.tdod.chargen.player.AbilityScoreEnum;
import org.tdod.chargen.player.AbilityScores;
import org.tdod.chargen.player.Alignment;
import org.tdod.chargen.player.CharacterClass;
import org.tdod.chargen.player.CharacterSheet;
import org.tdod.chargen.player.Languages;

public class Utilities {

    public static final String NUMBER_COMMA_REGEX = "[0-9,]*";
    public static final String COORDINATE_REGEX = "^[0-9]{1,3}[,][0-9]{1,3}";
    public static final String ALPHANUMERIC_REGEX = "[a-zA-Z0-9]*";
    public static final String NUMBER_REGEX = "[0-9]*";
    public static final String ALPHANUMERIC_UNDERSCORE_REGEX = "[a-zA-Z0-9_]*";


    public static boolean booleanFromString(String s) {
        return s.equals("1");
    }

    public static void initializeValidClasses(CharacterSheet character, List<CharacterClass> validClasses) {
        validClasses.clear();
        for (CharacterClass characterClass : CharacterClass.values()) {
            validClasses.add(characterClass);
        }
        
        List<CharacterClass> classValidationList = new ArrayList<CharacterClass>();
        classValidationList.add(CharacterClass.ELF);
        classValidationList.add(CharacterClass.HALFLING);
        classValidationList.add(CharacterClass.DWARF);
        classValidationList.add(CharacterClass.MYSTIC);
        
        for (CharacterClass characterClass : classValidationList) {
            Map<AbilityScoreEnum, Integer> minStatMap = characterClass.getMinimumStats();
            for (Map.Entry<AbilityScoreEnum, Integer> entry : minStatMap.entrySet()) {
                AbilityScoreEnum score = entry.getKey();
                Integer minimumValue = entry.getValue();
                
                int currentValue = character.getAbilityScores().getValue(score);
                if (currentValue < minimumValue) {
                    validClasses.remove(characterClass);
                    continue;
                }
                
            }
        }
    }
    
    public static int calculateHp(CharacterSheet character) {
        int conBonus = AbilityScores.getBonus(character.getAbilityScores().getConstitution());
        
        int hp = character.getCharacterClass().getHpDice().roll(1) + conBonus;
        
        if (hp < 1) {
            hp = 1;
        }

        return hp;
    }

    public static int calculateGold(Character character) {
        return Dice.D6.roll(3) * 10;
    }

    public static int updateCharacterLanguage(CharacterSheet character) {
        character.getLanguages().add(Languages.COMMON);
        
        if (character.getAbilityScores().getIntelligence() >= 9) {
            if (Alignment.LAW.equals(character.getAlignment())) {
                character.getLanguages().add(Languages.LAW);
            } else if (Alignment.NEUTRALITY.equals(character.getAlignment())) {
                character.getLanguages().add(Languages.NEUTRALITY);                
            } else if (Alignment.CHAOS.equals(character.getAlignment())) {
                character.getLanguages().add(Languages.CHAOS);                
            }
        }
        
        return AbilityScores.getBonus(character.getAbilityScores().getIntelligence());
    }

}
