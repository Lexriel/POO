import org.junit.*;
import static org.junit.Assert.*;

import example.Robot;   
import example.util.*;   

public class RobotTest {	

    @Test
    public void testTake() {
        Robot R2D2 = new Robot();
        Box someBox = new Box(50);
	R2D2.take(someBox);
    }


    @Test(expected = IllegalStateException.class)
    public void testTakeException() {
        Robot R2D2 = new Robot();
        Box someBox = new Box(50);
	R2D2.take(someBox);
        Box someBox2 = new Box(100);
	R2D2.take(someBox2);
    }
    
    @Test
    public void testCarryBox() {
        Robot R2D2 = new Robot();
        Box someBox = new Box(50);
	assertFalse(R2D2.carryBox());
	R2D2.take(someBox);
	assertTrue(R2D2.carryBox());
    }

    @Test
    public void testPutOn() {
        Robot R2D2 = new Robot();
        Box someBox = new Box(50);
	ConveyerBelt conveyer = new ConveyerBelt(200);
	R2D2.take(someBox);
	R2D2.putOn(conveyer);
	assertFalse(R2D2.carryBox());
	R2D2.take(new Box(300));
	assertTrue(R2D2.carryBox());
    }



    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(RobotTest.class);
    }

}
