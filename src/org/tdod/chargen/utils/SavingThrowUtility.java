package org.tdod.chargen.utils;

import java.util.HashMap;
import java.util.Map;

import org.tdod.chargen.player.AbilityScores;
import org.tdod.chargen.player.CharacterClass;
import org.tdod.chargen.player.SavingThrows;

public class SavingThrowUtility {

    private static Map<CharacterClass, Map<Integer, SavingThrows>> savingThrows = null;

    private SavingThrowUtility() {
    }

    public static SavingThrows calculateSavingThrows(CharacterClass characterClass, int level, int wisdom) {
        synchronized (SavingThrowUtility.class) {
            if (null == savingThrows) {
                intialize();
            }            
        }
        Map<Integer, SavingThrows> map = savingThrows.get(characterClass);
        SavingThrows savingThrows = map.get(Integer.valueOf(level));
        
        int mod = AbilityScores.getBonus(wisdom);
        
        savingThrows.setRodsStavesOrSpells((byte)(savingThrows.getRodsStavesOrSpells() - mod));
        
        return savingThrows;
    }
    
    private static void intialize() {
        savingThrows = new HashMap<CharacterClass, Map<Integer, SavingThrows>>();
        
        Map<Integer, SavingThrows> savingThrowsPerLevel = new HashMap<Integer, SavingThrows>();
        for (int level = 1; level <= 4; level = level + 1) {
            savingThrowsPerLevel.put(level, new SavingThrows((byte)11,(byte)12,(byte)14,(byte)16,(byte)15));            
        }
        savingThrows.put(CharacterClass.CLERIC, savingThrowsPerLevel);
        savingThrows.put(CharacterClass.DRUID, savingThrowsPerLevel);

        savingThrowsPerLevel = new HashMap<Integer, SavingThrows>();
        for (int level = 1; level <= 3; level = level + 1) {
            savingThrowsPerLevel.put(level, new SavingThrows((byte)12,(byte)13,(byte)14,(byte)15,(byte)16));            
        }
        savingThrows.put(CharacterClass.FIGHTER, savingThrowsPerLevel);
        savingThrows.put(CharacterClass.MYSTIC, savingThrowsPerLevel);

        savingThrowsPerLevel = new HashMap<Integer, SavingThrows>();
        for (int level = 1; level <= 5; level = level + 1) {
            savingThrowsPerLevel.put(level, new SavingThrows((byte)13,(byte)14,(byte)13,(byte)16,(byte)15));            
        }
        savingThrows.put(CharacterClass.MAGIC_USER, savingThrowsPerLevel);

        savingThrowsPerLevel = new HashMap<Integer, SavingThrows>();
        for (int level = 1; level <= 4; level = level + 1) {
            savingThrowsPerLevel.put(level, new SavingThrows((byte)13,(byte)14,(byte)13,(byte)16,(byte)15));            
        }
        savingThrows.put(CharacterClass.THIEF, savingThrowsPerLevel);

        savingThrowsPerLevel = new HashMap<Integer, SavingThrows>();
        for (int level = 1; level <= 3; level = level + 1) {
            savingThrowsPerLevel.put(level, new SavingThrows((byte)8,(byte)9,(byte)10,(byte)13,(byte)12));            
        }
        savingThrows.put(CharacterClass.DWARF, savingThrowsPerLevel);

        savingThrowsPerLevel = new HashMap<Integer, SavingThrows>();
        for (int level = 1; level <= 3; level = level + 1) {
            savingThrowsPerLevel.put(level, new SavingThrows((byte)12,(byte)13,(byte)13,(byte)15,(byte)15));            
        }
        savingThrows.put(CharacterClass.ELF, savingThrowsPerLevel);

        savingThrowsPerLevel = new HashMap<Integer, SavingThrows>();
        for (int level = 1; level <= 3; level = level + 1) {
            savingThrowsPerLevel.put(level, new SavingThrows((byte)8,(byte)9,(byte)10,(byte)13,(byte)12));            
        }
        savingThrows.put(CharacterClass.HALFLING, savingThrowsPerLevel);
    }

}
