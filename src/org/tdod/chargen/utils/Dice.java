package org.tdod.chargen.utils;

import java.util.Random;

public enum Dice {

    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20);
    
    private int dice;
    private static Random r = new Random();
    
    private Dice(int dice) {
        this.dice = dice;
    }
    
    public int roll(int rolls) {
        int min = rolls;
        int max = rolls * dice;
       
        int roll = r.nextInt(max - min + 1) + min;            
        
        return roll;        
    }

    public int getDiceSides() {
        return dice;
    }
}
