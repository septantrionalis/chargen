package org.tdod.chargen.state.impl;

import org.tdod.chargen.player.SavingThrows;
import org.tdod.chargen.utils.SavingThrowUtility;

public class CalculateOtherNumbersState extends AbstractState {

    @Override
    public void executeState() throws Exception {
        System.out.println("-=Calculate Other Numbers=-");
        
        context.getCharacterSheet().setLevel(1);
        SavingThrows savingThrows = SavingThrowUtility.calculateSavingThrows(context.getCharacterSheet().getCharacterClass(), context.getCharacterSheet().getLevel(), context.getCharacterSheet().getAbilityScores().getWisdom());
        context.getCharacterSheet().setSavingThrows(savingThrows);

        boolean done = false;
        do {
            System.out.printf("%s\t\t%s\n", "Level: ", context.getCharacterSheet().getLevel());        
            System.out.printf("%s\t%s\n", "Armor Class: ", context.getCharacterSheet().getArmorClass());
            System.out.printf("%s\t\t%s\n", "THAC0: ", context.getCharacterSheet().getArmorClass());

            System.out.println("Saving Throws:");
            System.out.printf("  %s\t\t%s\n", "Death Ray or Poison: ", context.getCharacterSheet().getSavingThrows().getDeathRayOrPoison());
            System.out.printf("  %s\t\t\t%s\n", "Magic Wands: ", context.getCharacterSheet().getSavingThrows().getMagicWands());
            System.out.printf("  %s\t%s\n", "Paralysis or Turn to Stone: ", context.getCharacterSheet().getSavingThrows().getParalysisOrTurnToStone());
            System.out.printf("  %s\t\t%s\n", "Dragon Breath: ", context.getCharacterSheet().getSavingThrows().getDragonBreath());
            System.out.printf("  %s\t%s\n", "Rod, Staff, or Spell: ", context.getCharacterSheet().getSavingThrows().getRodsStavesOrSpells());

            System.out.println("Press 'c' to continue.");
            char input = getInput();
            if ('c' == input) {
                done = true;
            }
        } while (!done);
        
        context.setState(new ChooseAlignmentState());
    }


}
