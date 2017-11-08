import org.junit.*;
import static org.junit.Assert.*;

public class DateTest{

    @Test
    public void testTomorrow(){
	// jours ne changeant pas le mois
	Date d1 = new Date(16, Month.may, 2016);
	Date d2 = new Date(17, Month.may, 2016);
	assertTrue(d1.tomorrow().equals(d2));
	// nouveau mois - février non bissextile
	Date d3 = new Date(28, Month.february, 2015);
	Date d4 = new Date(29, Month.february, 2015);
	Date d5 = new Date(1, Month.march, 2015);
	assertFalse(d3.tomorrow().equals(d4));
	assertTrue(d3.tomorrow().equals(d5));
	// nouveau mois - février bissextile
	Date d6 = new Date(28, Month.february, 2016);
	Date d7 = new Date(29, Month.february, 2016);
	Date d8 = new Date(1, Month.march, 2016);
	assertTrue(d6.tomorrow().equals(d7));
	assertTrue(d7.tomorrow().equals(d8));
	// nouvel an
	Date d9 = new Date(31, Month.december, 2016);
	Date d10 = new Date(1, Month.january, 2017);
	assertTrue(d9.tomorrow().equals(d10));
    }

    @Test
    public void testnDaysLater(){
	// un an passant par février non bissextile
	Date d1 = new Date(15, Month.may, 2016);
	Date d2 = new Date(15, Month.may, 2017);
	assertEquals(d1.nDaysLater(365), d2);
	// passage par février non bissextile
	Date d3 = new Date(25, Month.february, 2015);
	Date d4 = new Date(4, Month.march, 2015);
	assertEquals(d3.nDaysLater(7), d4);
	// passage par février bissextile
	Date d5 = new Date(25, Month.february, 2016);
	Date d6 = new Date(4, Month.march, 2016);
	assertEquals(d5.nDaysLater(8), d6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testnDaysLaterNegative(){
	Date d = new Date(15, Month.may, 2016);
	d.nDaysLater(-3);
    }

    // Pour permettre l'execution des test
    public static junit.framework.Test suite(){
	return new junit.framework.JUnit4TestAdapter(DateTest.class);
    }


}
