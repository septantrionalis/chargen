package org.tdod.chargen.state.impl;

import org.tdod.chargen.equipment.ArmorFactory;
import org.tdod.chargen.equipment.ShieldFactory;

public class SelectEquipmentState extends AbstractState {

    @Override
    public void executeState() throws Exception {
        System.out.println("-=Select Equipment=-");
        System.out.println("Initializing default equipment.");
        context.getCharacterSheet().setArmor(ArmorFactory.NO_ARMOR.getArmor());
        context.getCharacterSheet().setShield(ShieldFactory.NO_SHIELD.getShield());
        context.setState(new CalculateOtherNumbersState());
        
        boolean done = false;
        do {
            System.out.println("Press 'c' to continue.");
            char input = getInput();
            if ('c' == input) {
                done = true;
            }
        } while (!done);
    }

}
