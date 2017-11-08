
import static org.junit.Assert.*;
import goosegame.*;
import java.util.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameTest{

    private Cell cell;
    private Player player1;
    private Player player2;
    private Player player3;
    private Board board; // changé
    private Game game;
	
    @Before
    public void setUpBeforeClass() throws Exception{
	this.board = ClassicBoard.THE_BOARD;
	this.game = new Game(board);
	this.player1 = new Player("Michel");
	this.player2 = new Player("Robert");
	this.player3 = new Player("Michel");
	this.cell = new BasicCell(55);
    }

    @Test
    public void testAddPlayer(){
	game.addPlayer(player1);
	System.out.println(game.getThePlayers());
	assertEquals(game.getThePlayers().get(0), player1);	
    }

    @Test
    public void testEquals(){
	assertTrue(this.player1.equals(this.player3));
	assertFalse(this.player1.equals(this.player2));
    }

    @Test
    public void testNextPlayer(){
	game.addPlayer(this.player1);
	game.addPlayer(this.player2);
	System.out.println(game.getThePlayers().get(0).toString());
	System.out.println(game.getThePlayers().get(1).toString());
	assertTrue(game.nextPlayer().equals(this.player1) );
	/*assertEquals(game.nextPlayer(),player2);*/
	/*assertEquals(game.nextPlayer(),player1);*/	
    }


    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite(){
	return new junit.framework.JUnit4TestAdapter(GameTest.class);
    }
}
