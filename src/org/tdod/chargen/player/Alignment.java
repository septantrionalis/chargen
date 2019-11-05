package org.tdod.chargen.player;

public enum Alignment {

    LAW("LAW"),
    NEUTRALITY("NEUTRALITY"),
    CHAOS("CHAOS");
    
    private String displayName;
    
    private Alignment(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    
}
