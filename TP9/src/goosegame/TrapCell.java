
/**
 * TrapCell.java
 *
 *
 * Created: Mon May 27 10:09:16 2002
 *
 * @author <a href="mailto:routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
package goosegame;

public class TrapCell extends BasicCell{

    public TrapCell (int index){
	super(index);
    }
    
    public boolean canBeLeft() {
	return false;
    }
    public String toString() {
	return super.toString()+" (trap)";
    }
}// TrapCell
