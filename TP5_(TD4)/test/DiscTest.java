import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.Disc;

public class DiscTest {

	@Test
	public void disque() {
		Disc d = new Disc(5);
		assertNotNull(d);
	}

	@Test
	public void taille() {
		Disc d = new Disc(5);
		assertEquals(5, d.getTaille());
	}

	// --- Pour permettre l'execution des test----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(DiscTest.class);
	}

}
