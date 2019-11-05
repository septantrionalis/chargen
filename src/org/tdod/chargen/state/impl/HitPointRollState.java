package org.tdod.chargen.state.impl;

import org.tdod.chargen.player.AbilityScores;
import org.tdod.chargen.utils.Dice;

public class HitPointRollState extends AbstractState {

    @Override
    public void executeState() throws Exception {
        System.out.println("-=Hit Points=-");
        
        int hp = context.getCharacterSheet().getCharacterClass().getHpDice().getDiceSides();
        int bonus = AbilityScores.getBonus(context.getCharacterSheet().getAbilityScores().getConstitution());
        
        context.getCharacterSheet().setMaxHp(hp + bonus);

        System.out.println("Hit Points: " + context.getCharacterSheet().getMaxHp());
        
        int gold = Dice.D6.roll(3) * 10;

        context.getCharacterSheet().setGold(gold);
        
        System.out.println("Gold: " + context.getCharacterSheet().getGold());

        context.setState(new SelectEquipmentState());
    }

}
