
import static org.junit.Assert.*;
import goosegame.BasicCell;
import goosegame.Cell;
import goosegame.Player;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {

    private Cell cell;
    private Player player;
	
    @Before
    public void setUpBeforeClass() throws Exception {
	this.cell = new BasicCell(55);
	this.player = new Player("playerTest");
    }

    @Test
    public void testPlayer() {
	assertNotNull("player created ?", player);
    }

    @Test
    public void testGetSetCell() {
	// same tests for setter and getter 
	assertNull("no cell set", player.getCell());
	player.setCell(cell);
	assertNotNull("cell set", player.getCell());		
	assertSame("same cell ?",cell, player.getCell());
	assertNotSame("not same cell ?",new BasicCell(55), player.getCell());
    }

    /** A useless (mock) class of interface cell only to achieve tests */
    // private class DummyCell implements Cell {
    // 	public boolean canBeLeft() {
    // 	    return false;
    // 	}
    // 	public int getIndex() {
    // 	    return 0;
    // 	}
    // 	public int handleMove(int diceThrow) {
    // 	    return 0;
    // 	}
    // 	public boolean isBusy() {
    // 	    return false;
    // 	}
    // 	public void welcomePlayer(Player player) {
    // 	}
    // 	public Player getPlayer() {
    // 	    return null;
    // 	}
    // }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(PlayerTest.class);
    }
    // public static void main(String[] args) {
    // 	org.junit.runner.JUnitCore.main("PlayerTest");
    // }
}
