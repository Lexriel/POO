package rps;

import java.util.*;

public enum Shape{

    ROCK, PAPER, SCISSORS;
    private static Random alea = new Random();

    /** compares 2 shapes
	@return -1 if this looses vs c, 1 si this wins vs c, 0 else  */
    public int compareShape(Shape c){

	if (this == c)
	    return 0;

	// if (this == ROCK){
	//     if (c == PAPER)
	//     	return -1;
	//     else
	//     	return 1;
	// }
	if (this == ROCK)
	    return (c == PAPER) ? -1: 1;
	if (this == PAPER)
	    return (c == SCISSORS) ? -1: 1;
	if (this == SCISSORS)
	    return (c == ROCK) ? -1: 1;
	return 0;
    }

    /** returns a random shape
	@return a random shape */
    public static Shape random(){
	return Shape.values()[alea.nextInt(Shape.values().length)];
    }
}
