package org.tdod.chargen.state.impl;

public class CompletedState extends AbstractState {

    @Override
    public void executeState() throws Exception {
        System.out.println("Done.");
        context.setState(this);
    }

}
