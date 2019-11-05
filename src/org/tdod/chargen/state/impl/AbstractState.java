package org.tdod.chargen.state.impl;

import org.tdod.chargen.Context;
import org.tdod.chargen.state.StateIF;

public abstract class AbstractState implements StateIF {

    protected Context context;
    
    @Override
    public void execute(Context context) throws Exception {
        this.context = context;
        executeState();
    }
    
    protected char getInput() {
        System.out.print("> ");
        return context.getReader().next().charAt(0);
    }

    protected abstract void executeState() throws Exception;
}
