package rps.strategy;

import rps.Strategy;
import rps.Shape;

public class RandomStrat implements Strategy{

    public Shape chooseShape(){
	return Shape.random();
    }
}

