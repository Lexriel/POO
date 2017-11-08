
/**
 * WaitCell.java
 *
 *
 * Created: Mon May 27 10:09:16 2002
 *
 * @author <a href="mailto:routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
package goosegame;

public class Waiting extends BasicCell {

    protected int waitTime;
    protected int waitDuration;

    public Waiting (int index, int waitDuration){
	super(index);
	this.waitDuration = waitDuration;
    }
    
    public boolean canBeLeft() {
	return (waitTime--) == 0;
    }

    public void welcomePlayer(Player player) {
	super.welcomePlayer(player);
	waitTime = waitDuration;
    }

    public String toString() {
	return super.toString()+" (wait for "+this.waitDuration+" turns )";
    }
}// WaitCell
