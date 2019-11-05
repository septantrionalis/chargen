package org.tdod.chargen.state.impl;

import java.util.ArrayList;
import java.util.List;

import org.tdod.chargen.player.CharacterClass;
import org.tdod.chargen.utils.Utilities;

public class ChooseCharacterClassState extends AbstractState {

    private List<CharacterClass> validClasses = new ArrayList<CharacterClass>();

    @Override
    public void executeState() throws Exception {
        System.out.println("-=Classes=-");

        displayValidClasses();
        
        boolean done = false;
        CharacterClass characterClass = null;
        do {
            System.out.println("Select a class.");
            try {
                characterClass = validClasses.get((int)getInput() - 48);
                done = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        } while (!done);

        context.getCharacterSheet().setCharacterClass(characterClass);
        
        System.out.println("Chosen class is " + context.getCharacterSheet().getCharacterClass());
        
        context.setState(new AbilityScoreExchangeState());
    }

    private void displayValidClasses() {
        Utilities.initializeValidClasses(context.getCharacterSheet(), validClasses);

        for (int index = 0; index < validClasses.size(); index++) {
            System.out.println(index + ": " + validClasses.get(index).getDisplayName());
        }
    }
}
