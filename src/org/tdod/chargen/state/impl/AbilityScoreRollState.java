package org.tdod.chargen.state.impl;

import java.util.Arrays;

import org.tdod.chargen.player.AbilityScores;
import org.tdod.chargen.utils.Dice;

public class AbilityScoreRollState extends AbstractState {

    private AbilityScores abilityScores = new AbilityScores();

    @Override
    public void executeState() throws Exception {

        char input = ' ';
        do {
            rollAbilityScores();
            System.out.println("-=Ability Scores=-");
            System.out.println("Strength:     " + abilityScores.getStrength());
            System.out.println("Constitution: " + abilityScores.getConstitution());
            System.out.println("Dexterity:    " + abilityScores.getDexterity());
            System.out.println("Intelligence: " + abilityScores.getIntelligence());
            System.out.println("Wisdom:       " + abilityScores.getWisdom());
            System.out.println("Charisma:     " + abilityScores.getCharisma());
            System.out.println("Press 'y' to accept or 'r' to reroll.");
            
            input = getInput();
        } while (input == 'r');

        context.getCharacterSheet().setAbilityScores(abilityScores);
        
        context.setState(new ChooseCharacterClassState());
    }

    private void rollAbilityScores() {
        abilityScores.setStrength(getStat());
        abilityScores.setIntelligence(getStat());
        abilityScores.setWisdom(getStat());
        abilityScores.setDexterity(getStat());
        abilityScores.setConstitution(getStat());
        abilityScores.setCharisma(getStat());
    }

    /**
     * This method rolls the dice 4 times, and sums up the 3 highest values.
     * @return an ability score value.
     */
    private int getStat() {
        int rolls = 4;
        int[] score = new int[rolls];

        // Roll the dice.
        for (int index = 0; index < rolls; index++) {
            score[index] = Dice.D6.roll(1);
        }
        
        // Take the 3 highest values.
        Arrays.sort(score);
        int sum = 0;
        for (int index = 1; index < rolls; index++) {
            sum += score[index];
        }
        
        return sum;
    }

}


