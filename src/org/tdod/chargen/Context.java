package org.tdod.chargen;

import java.util.Scanner;

import org.tdod.chargen.player.CharacterSheet;
import org.tdod.chargen.state.StateIF;
import org.tdod.chargen.state.impl.CompletedState;

public class Context {

    private StateIF state;
    private int stateIndex = 0;
    private CharacterSheet characterSheet = new CharacterSheet();
    private Scanner reader = new Scanner(System.in);
    
    public Context(StateIF startingState) throws Exception {
        state = startingState;
    }

    public void execute() {
        try {
            this.setState(state);

            do {
                state.execute(this);
                stateIndex++;
            } while (state.getClass() != CompletedState.class);
            
            state.execute(this); // Run the final state.
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        reader.close();
    }

    public CharacterSheet getCharacterSheet() {
        return characterSheet;
    }

    public void setCharacterSheet(CharacterSheet characterSheet) {
        this.characterSheet = characterSheet;
    }
    
    public void setState(StateIF state) {
        this.state = state;
    }

    public StateIF getState() {
        return state;
    }

    public int getStateIndex() {
        return stateIndex;
    }

    public Scanner getReader() {
        return reader;
    }

    public void setReader(Scanner reader) {
        this.reader = reader;
    }

    
}
