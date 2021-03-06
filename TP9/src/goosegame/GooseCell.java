/**
 * GooseCell.java
 *
 *
 * Created: Mon May 27 10:09:16 2002
 *
 * @author <a href="mailto:routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
package goosegame;

public class GooseCell extends BasicCell {

    public GooseCell(int index) {
	super(index);
    }

    public int handleMove(int dieThrow) {
	return index + dieThrow;
    }
    public String toString() {
	return super.toString()+" (goose)";
    }
}// GooseCell
