import org.junit.*;
import static org.junit.Assert.*;

import example.util.Box;   

public class BoxTest {	

    @Test
    public void testBoxCreation() {
        Box someBox = new Box(10);
        assertNotNull(someBox);
        assertEquals(10,someBox.getWeight()); 
    }
    
    @Test
    public void donnePoids() {
        Box someBox = new Box(10);
        assertEquals(10,someBox.getWeight());
        someBox = new Box(20);
        assertSame(20,someBox.getWeight()); 
	// sur les types primitis assertEquals et assertSame reviennent au meme
    }



    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(BoxTest.class);
    }

}
