package org.tdod.chargen.state.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tdod.chargen.player.Languages;
import org.tdod.chargen.utils.Utilities;

public class ChooseLanguageState extends AbstractState {

    @Override
    public void executeState() throws Exception {
        System.out.println("-=Languages=-");
        
        int bonusLanguages = Utilities.updateCharacterLanguage(context.getCharacterSheet());
        
        
        boolean done = false;
        do {
            displayCurrentLanguages();
            
            if (bonusLanguages > 0) {
                displayLanguagesToLearn();
                if (bonusLanguages == 1) {
                    System.out.println("Select " + bonusLanguages + " additional language or 'c' to continue.");                                        
                } else {
                    System.out.println("Select " + bonusLanguages + " additional languages or 'c' to continue.");                    
                }
            } else {
                System.out.println("No additional languages can be learned.  Press 'c' to continue.");
            }
            
            char input = getInput();
            
            if ('c' == input) {
                done = true;
            } else {
                Languages[] languagesArray = Languages.values();
                List<Languages> learnableLanguageList = new ArrayList<Languages>(Arrays.asList(languagesArray));
                // Remove languages already learned.
                for (Languages languages : context.getCharacterSheet().getLanguages()) {
                    learnableLanguageList.remove(languages);
                }

                try {
                    Languages language = learnableLanguageList.get(Integer.valueOf(input) - 48);
                    context.getCharacterSheet().getLanguages().add(language);
                    bonusLanguages--;
                } catch (Exception e) {
                    System.out.println("Invalid input. Try again.");
                }
            }
        } while (!done);
        
        context.setState(new CompletedState());
    }
    
    private void displayCurrentLanguages() {
        List<Languages> languages = context.getCharacterSheet().getLanguages();
        System.out.println("Current languages: ");
        for (Languages language : languages) {
            System.out.println("  " + language);            
        }
    }
    
    private void displayLanguagesToLearn() {
        Languages[] languagesArray = Languages.values();
        List<Languages> learnableLanguageList = new ArrayList<Languages>(Arrays.asList(languagesArray));

        // Remove languages already learned.
        for (Languages languages : context.getCharacterSheet().getLanguages()) {
            learnableLanguageList.remove(languages);
        }
        
        System.out.println("Learnable languages:");
        for (int count = 0; count < learnableLanguageList.size(); count++) {
            System.out.println(count + ": " + learnableLanguageList.get(count));
        }
    }
}
