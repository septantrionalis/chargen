package org.tdod.chargen.state.impl;

import java.util.ArrayList;
import java.util.List;

import org.tdod.chargen.player.AbilityScoreEnum;
import org.tdod.chargen.player.AbilityScores;

public class AbilityScoreExchangeState extends AbstractState {

    private AbilityScores modifiedAbilityScores = new AbilityScores();
    private List<AbilityScoreEnum> validAbilityScoresToLower = new ArrayList<AbilityScoreEnum>();
    private List<AbilityScoreEnum> validAbilityScoresToRaise = new ArrayList<AbilityScoreEnum>();
    private boolean done = false;
    
    @Override
    public void executeState() throws Exception {
        System.out.println("-=Ability Score Exchange=-");

        modifiedAbilityScores.setAbilityScores(context.getCharacterSheet().getAbilityScores());
        do {
            AbilityScoreEnum abilityScoreToLower = null;
            AbilityScoreEnum abilityScoreToRaise = null;
            calculateValidScoresToLower();
            calculateValidScoresToRaise();
            if (validAbilityScoresToLower.size() > 0 &&
                validAbilityScoresToRaise.size() > 0) {
                displayValidScoresToLower();
                
                abilityScoreToLower = getAbilityScoreToModify(validAbilityScoresToLower, true);
                
                if (!done && null != abilityScoreToLower) {
                    displayValidScoresToRaise();

                    abilityScoreToRaise = getAbilityScoreToModify(validAbilityScoresToRaise, false);
                    
                    modifiedAbilityScores.setValue(abilityScoreToLower, modifiedAbilityScores.getValue(abilityScoreToLower) - 2);
                    modifiedAbilityScores.setValue(abilityScoreToRaise, modifiedAbilityScores.getValue(abilityScoreToRaise) + 1);                    
                }
            }
            
            if ((validAbilityScoresToLower.size() == 0) ||
                validAbilityScoresToRaise.size() == 0) {
                System.out.println("Ability scores cannot be modified any further.  Press 'c' to continue or 'r' to reset.");
                
                char c = getInput();
                if ('c' == c) {
                    done = true;
                } else if ('r' == c) {
                    modifiedAbilityScores.setAbilityScores(context.getCharacterSheet().getAbilityScores());
                }
            }
        } while (!done);
        
        context.getCharacterSheet().getAbilityScores().setAbilityScores(modifiedAbilityScores);
        context.setState(new HitPointRollState());
    }

    private void calculateValidScoresToLower() {
        List<AbilityScoreEnum> primeRequisites = context.getCharacterSheet().getCharacterClass().getPrimeRequisites();
        
        validAbilityScoresToLower.clear();
        if (modifiedAbilityScores.getStrength() > AbilityScores.MIN_ABILITY_SCORE) {
            validAbilityScoresToLower.add(AbilityScoreEnum.STRENGTH);
        }
        if (modifiedAbilityScores.getIntelligence() > AbilityScores.MIN_ABILITY_SCORE) {
            validAbilityScoresToLower.add(AbilityScoreEnum.INTELLIGENCE);
        }
        if (modifiedAbilityScores.getWisdom() > AbilityScores.MIN_ABILITY_SCORE) {
            validAbilityScoresToLower.add(AbilityScoreEnum.WISDOM);
        }
        
        for (AbilityScoreEnum abilityScoreEnum : primeRequisites) {
            validAbilityScoresToLower.remove(abilityScoreEnum);
        }
    }
    
    private void displayValidScoresToLower() {
        for (int index = 0; index < validAbilityScoresToLower.size(); index++) {
            AbilityScoreEnum abilityScore = validAbilityScoresToLower.get(index);
            Integer value = modifiedAbilityScores.getValue(abilityScore);
            System.out.printf("%s\t%s\n", index + ": " + validAbilityScoresToLower.get(index).getDisplayName(), value.toString());
        }
        
        System.out.println("Select an ability score to lower, 'r' to reset, or 'c' to continue.");
    }
    
    private void calculateValidScoresToRaise() {
        List<AbilityScoreEnum> primeRequisites = context.getCharacterSheet().getCharacterClass().getPrimeRequisites();

        validAbilityScoresToRaise.clear();
        for (AbilityScoreEnum abilityScoreEnum : primeRequisites) {
            if (modifiedAbilityScores.getValue(abilityScoreEnum) < AbilityScores.MAX_ABILITY_SCORE) {
                validAbilityScoresToRaise.add(abilityScoreEnum);                
            }
        }
    }
    
    private void displayValidScoresToRaise() {
        for (int index = 0; index < validAbilityScoresToRaise.size(); index++) {
            AbilityScoreEnum abilityScore = validAbilityScoresToRaise.get(index);
            Integer value = modifiedAbilityScores.getValue(abilityScore);
            System.out.printf("%s\t%s\n", index + ": " + validAbilityScoresToRaise.get(index).getDisplayName(), value.toString());
        }
        
        System.out.println("Select an ability score to raise.");
    }

    private AbilityScoreEnum getAbilityScoreToModify(List<AbilityScoreEnum> validAbilityScores, boolean lower) {
        boolean isValidInput = false;
        AbilityScoreEnum abilityScoreToModify = null;
        do {
            try {
                char c = getInput();
                if (lower) {
                    if ('c' == c) {
                        done = true;
                        return null;
                    } else if ('r' == c) {
                        modifiedAbilityScores.setAbilityScores(context.getCharacterSheet().getAbilityScores());
                        return null;
                    }
                }
                abilityScoreToModify = validAbilityScores.get((int)c - 48);
                isValidInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        } while (!isValidInput);
        
        return abilityScoreToModify;
    }
}
