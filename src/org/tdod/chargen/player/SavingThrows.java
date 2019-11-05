package org.tdod.chargen.player;

import java.util.HashMap;
import java.util.Map;

public class SavingThrows {

    
    private byte deathRayOrPoison = 0;
    private byte magicWands = 0;
    private byte paralysisOrTurnToStone = 0;
    private byte dragonBreath = 0;
    private byte rodsStavesOrSpells = 0;
    
    public SavingThrows() {
    }
    
    public SavingThrows(byte deathRayOrPoison, byte magicWands, byte paralysisOrTurnToStone, byte dragonBreath, byte rodsStavesOrSpells) {
        this.deathRayOrPoison = deathRayOrPoison;
        this.magicWands = magicWands;
        this.paralysisOrTurnToStone = paralysisOrTurnToStone;
        this.dragonBreath = dragonBreath;
        this.rodsStavesOrSpells = rodsStavesOrSpells;
    }

    public byte getDeathRayOrPoison() {
        return deathRayOrPoison;
    }
    
    public void setDeathRayOrPoison(byte deathRayOrPoison) {
        this.deathRayOrPoison = deathRayOrPoison;
    }
    
    public byte getMagicWands() {
        return magicWands;
    }
    
    public void setMagicWands(byte magicWands) {
        this.magicWands = magicWands;
    }
    
    public byte getParalysisOrTurnToStone() {
        return paralysisOrTurnToStone;
    }
    
    public void setParalysisOrTurnToStone(byte paralysisOrTurnToStone) {
        this.paralysisOrTurnToStone = paralysisOrTurnToStone;
    }
    
    public byte getDragonBreath() {
        return dragonBreath;
    }
    
    public void setDragonBreath(byte dragonBreath) {
        this.dragonBreath = dragonBreath;
    }
    
    public byte getRodsStavesOrSpells() {
        return rodsStavesOrSpells;
    }
    
    public void setRodsStavesOrSpells(byte rodsStavesOrSpells) {
        this.rodsStavesOrSpells = rodsStavesOrSpells;
    }
    
}
