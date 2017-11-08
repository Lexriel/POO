/**
 * BasicCell.java
 *
 *
 * @author <a href="mailto:jean-christophe.routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
package goosegame;

public class BasicCell implements Cell {

    protected final int index;

    protected Player player;

    public BasicCell(int index) {
	this.index = index;
	player = null;
    }

    public boolean canBeLeft() {
	return true;
    }

    public int getIndex() {
	return index;
    }

    public int handleMove(int dieThrow) {
	return index;
    }

    public boolean isBusy() {
	return player != null;
    }

    public void welcomePlayer(Player player) {
	this.player = player;
	if (player != null) {
	    player.setCell(this);
	}
    }

    public Player getPlayer() {
	return player;
    }

    public String toString() {
	return "cell "+this.index;
    }
}// BasicCell
