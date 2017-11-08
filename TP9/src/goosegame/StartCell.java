package goosegame;

/** Pour repr�enter la premi�re cellule du plateau : celle de d�part, d'incide 0
 * @author JC
 *
 */
public class StartCell implements Cell {

    public boolean canBeLeft() {		
	return true;
    }

    public int handleMove(int dieThrow) {		
	return 0;
    }

    public int getIndex() {		
	return 0;
    }

    public Player getPlayer() {
	// on s'en moque
	return null;
    }

    public boolean isBusy() {
	return false;
    }

    public void welcomePlayer(Player player) {
	// on s'en moque
    }
    public String toString() {
	return " start cell";
    }
}
