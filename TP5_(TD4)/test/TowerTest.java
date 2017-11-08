import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.Disc;
import hanoi.util.Tower;

public class TowerTest {

	@Test
	public void Tower() {
		Tower t = new Tower(5);
		assertNotNull(t);
	}

	@Test
	public void getCapacite() {
		Tower t = new Tower(5);
		assertEquals(5, t.getCapacite());
	}

	@Test
	public void getNbDiscs() {
		Tower t = new Tower(5);
		assertEquals(0, t.getNbDiscs());
		t.push(new Disc(3));
		assertEquals(1, t.getNbDiscs());
	}

	@Test
	public void isFull() {
		Tower t = new Tower(1);
		assertFalse(t.isFull());
		t.push(new Disc(3));
		assertTrue(t.isFull());
	}

	@Test
	public void isEmpty() {
		Tower t = new Tower(1);
		assertTrue(t.isEmpty());
		t.push(new Disc(3));
		assertFalse(t.isEmpty());
	}

	@Test
	public void sommetEtEmpiler() {
		Tower t = new Tower(5);
		Disc d = new Disc(4);
		t.push(d);
		assertEquals(t.getNbDiscs(), 1);
		assertSame(d, t.top());
	}

	@Test
	public void pop() {
		Tower t = new Tower(5);
		Disc d = new Disc(4);
		t.push(d);
		Disc d2 = t.pop();
		assertEquals(0, t.getNbDiscs());
		assertSame(d, d2);
	}

	// ---Pour permettre l'execution des test----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(TowerTest.class);
	}

}
