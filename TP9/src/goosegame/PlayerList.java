package goosegame;

import java.util.*;

/**
 * list of the players of a "jeu de l'oie" game, it is assumed that 
 * no player are removed or added while game has begun (this could be 
 * secured by the <tt>Board</tt> object which controls this list.
 * <p>
 * It is a circular list, successive calls to <t>nextPlayer()</t> produces 
 * the periodical series of players of the list.
 */

public class PlayerList {

    private List<Player> thePlayers;

    private Iterator<Player> playerIt;

    public PlayerList() {
	thePlayers = new ArrayList<Player>();
    }

    /**
     * @param player the player to be added
     */
    public void addPlayer(Player player) {
	thePlayers.add(player);
    }

    /** returns the next player considering the list as a circular (infinite) one
     * @return the next player
     */
    public Player nextPlayer() {
	if (playerIt == null || !playerIt.hasNext()) {
	    playerIt = thePlayers.iterator();
	}
	return playerIt.next();
    }

}// PlayerList
