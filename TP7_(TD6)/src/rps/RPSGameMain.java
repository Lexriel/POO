package rps;

import rps.strategy.InteractiveStrat;
import rps.strategy.RandomStrat;

public class RPSGameMain{
    public static void main(String[] args){
	Player p1 = new Player("p1", new RandomStrat());
	Player p2 = new Player("p2", new InteractiveStrat());
	Game p = new Game(p1, p2, 10);
	p.playGame();
    }
}
