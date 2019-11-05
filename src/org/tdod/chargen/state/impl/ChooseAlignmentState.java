package org.tdod.chargen.state.impl;

import org.tdod.chargen.player.Alignment;
import org.tdod.chargen.player.CharacterClass;

public class ChooseAlignmentState extends AbstractState {

    @Override
    public void executeState() throws Exception {
        System.out.println("-=Alignment=-");

        displayValidAlignments();
        
        boolean done = false;
        Alignment alignment = null;
        do {
            System.out.println("Select an alignment.");
            try {
                Alignment[] alignments = Alignment.values();
                alignment = alignments[(int)getInput() - 48];
                done = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        } while (!done);

        context.getCharacterSheet().setAlignment(alignment);

        System.out.println("Selected " + context.getCharacterSheet().getAlignment().getDisplayName());

        context.setState(new ChooseLanguageState());
    }
    
    private void displayValidAlignments() {
        Alignment[] alignments = Alignment.values();
        
        for(int index = 0; index < alignments.length; index++) {
            System.out.println(index + ": " + alignments[index].getDisplayName());
        }
    }

}
