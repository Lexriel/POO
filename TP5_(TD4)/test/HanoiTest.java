import org.junit.*;
import static org.junit.Assert.*;

import hanoi.Hanoi;
import hanoi.util.*;

public class HanoiTest {	

    @Test
    public void testExecute(){
		int nbDisc = 3;
		Hanoi jeu = new Hanoi(nbDisc);
		System.out.println(jeu.getTower(1)/*.getNbDisc()*/);
		assertEquals(3,jeu.getTower(1).getNbDisc());
	}
	
	
    @Test
    public void testMove(){
		Hanoi jeu = new Hanoi(3);
		assertEquals(0,jeu.getTower(2).getNbDisc());
		jeu.moveOneDisc(0,1);
		assertEquals(1,jeu.getTower(2).getNbDisc());
	}
    
    
    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(HanoiTest.class);
    }

}
