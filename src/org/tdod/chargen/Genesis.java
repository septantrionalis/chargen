package org.tdod.chargen;

import org.tdod.chargen.state.impl.AbilityScoreRollState;

public class Genesis {

    public Genesis() {
        try {
            Context context = new Context(new AbilityScoreRollState());
            context.execute();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        new Genesis();
    }

}
