package org.tdod.chargen.player;

public enum Languages {

    COMMON("COMMON"),
    LAW(Alignment.LAW.getDisplayName()),
    NEUTRALITY(Alignment.NEUTRALITY.getDisplayName()),
    CHAOS(Alignment.CHAOS.getDisplayName()),
    ELF("ELF"),
    GNOLL("GNOLL"), 
    HOBGOBLIN("HOBGOBLIN"),
    ORC("ORC"),
    DWARF("DWARF"), 
    GNOME("GNOME"),
    GOBLIN("GOBLIN"),
    KOBOLD("KOBOLD");
    
    private String displayName;
    
    private Languages(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    
}
