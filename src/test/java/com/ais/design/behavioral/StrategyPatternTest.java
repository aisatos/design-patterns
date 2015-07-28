package com.ais.design.behavioral;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Group several algorithms in a single module to provide alternatives. Also known as policy.
 */
public class StrategyPatternTest {

	@Test
	public void test() {
		int luckyNum = new Dice().throwIt();
        FortuneCookies fc;
        switch (luckyNum) {
        	case 1: fc = new NeverTooLate();
        			break;
            case 3: fc = new JohnSnow();
    				break;
            case 5: fc = new YourTurn();
                    break;
            //more
            default: fc = new NoLuck();
        }
        assertNotNull("Fortune shouldn't be null", fc.getFortune());
    
	}

}

interface FortuneCookies {
    public String getFortune();
}
class YourTurn implements FortuneCookies {
    public String getFortune() {
    	return "It is your turn to get it";
    }
}
class NeverTooLate implements FortuneCookies {
    public String getFortune() {
    	return "It is never too late to start";
    }
}
class NoLuck implements FortuneCookies {
    public String getFortune() {
        return "You got nothing";    
    }
}
class JohnSnow implements FortuneCookies {
    public String getFortune() {
        return "You know nothing";    
    }
}
class Dice {
   public int throwIt() {
       return (int)(Math.random()*6)+1;
   }
}