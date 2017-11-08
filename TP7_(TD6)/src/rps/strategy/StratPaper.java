package rps.strategy;

import rps.Strategy;
import rps.Shape;

public class StratPaper implements Strategy{

    public Shape chooseShape(){
	return Shape.PAPER;
    }
}
