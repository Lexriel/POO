import org.junit.*;
import static org.junit.Assert.*;

import bibliotheque.BorrowDate;

public class DateEmpruntTest{

    @Test
    public void ecartJoursTest(){
	DateEmprunt d1 = new DateEmprunt(2015, 140);
	DateEmprunt d2 = new DateEmprunt(2015, 220);
	assertEquals(80, d1.ecartEnJours(d2));
	assertEquals(80, d2.ecartEnJours(d1));
	assertNotNull(d);
    }

    // @Test
    // public void taille(){
    // 	Disc d = new Disc(5);
    // 	assertEquals(5, d.getTaille());
    // }

    // --- Pour permettre l'execution des test----------------------
    public static junit.framework.Test suite(){
	return new junit.framework.JUnit4TestAdapter(DateEmpruntTest.class);
    }

}
