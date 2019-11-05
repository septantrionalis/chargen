package org.tdod.chargen.player;

public enum AbilityScoreEnum {

    STRENGTH("Strength"),
    INTELLIGENCE("Intelligence"),
    WISDOM("Wisdom"),
    DEXTERITY("Dexterity"),
    CONSTITUTION("Constitution"),
    CHARISMA("Charisma");

    private String displayName;
    
    private AbilityScoreEnum(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
