package rps.strategy;

import rps.Strategy;
import rps.Shape;

public class StratScissors implements Strategy{

    public Shape chooseShape(){
	return Shape.SCISSORS;
    }
}
