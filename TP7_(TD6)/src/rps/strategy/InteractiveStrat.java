package rps.strategy;

import rps.Strategy;
import rps.Shape;
import util.Input;

public class InteractiveStrat implements Strategy{

    public Shape chooseShape(){
	Shape c = null;
	while (c == null){
	    System.out.println("which shape do you play ? (rock, paper, scissors) ");
	    String answer = Input.readString();
	    try{
		c = Shape.valueOf(answer.toUpperCase());
	    }
	    catch (IllegalArgumentException e){
		// invalid input
		c = null;
	    }
	}
	return c;
    }
}
