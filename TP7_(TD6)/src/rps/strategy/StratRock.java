package rps.strategy;

import rps.Strategy;
import rps.Shape;

public class StratRock implements Strategy{

    public Shape chooseShape(){
	return Shape.ROCK;
    }
}
