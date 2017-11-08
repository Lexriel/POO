package rps;

public class Game{

    private Player p1;
    private Player p2;
    private int nbTours;

    private static final int VICTORY_POINTS = 2;
    private static final int DEFEAT_POINTS = 0;
    private static final int TIE_POINTS = 1;

    public Game(Player p1, Player p2, int nb){
	this.p1 = p1;
	this.p2 = p2;
	this.nbTours = nb;
    }

    public void playGame(){
	for (int i = 0; i < nbTours; i++){
	    this.playOneRound();
	}
	this.endOfGame();
    }

    private void endOfGame(){
	int score1 = this.p1.getScore();
	int score2 = this.p2.getScore();
	System.out.println("********");
	System.out.println(this.p1 + " wins " + score1 + " points");
	System.out.println(this.p2 + " wins " + score2 + " points");
	if (score1 > score2)
	    System.out.println(this.p1 + " wins the game");
	else{
	    if (score2 > score1)
		System.out.println(this.p2 + " wins the game");
	    else
		System.out.println("Tie game");
	}
    }

    private void playOneRound(){
	System.out.println("******** new round *****");
	Shape c1 = this.p1.play();
	Shape c2 = this.p2.play();

	System.out.println(this.p1 + " plays " + c1);
	System.out.println(this.p2 + " plays " + c2);
	int income = c1.compareShape(c2);
	this.givePoints(income);
    }

    private void givePoints(int income){
	if (income == 0){
	    this.p1.addPoints(Game.TIE_POINTS);
	    this.p2.addPoints(Game.TIE_POINTS);
	    System.out.println("Tie round");
	}
	else if (income < 0){
	    this.p2.addPoints(Game.VICTORY_POINTS);
	    this.p1.addPoints(Game.DEFEAT_POINTS);
	    System.out.println(this.p2 + " wins");
	}
	else{
	    this.p1.addPoints(Game.VICTORY_POINTS);
	    this.p2.addPoints(Game.DEFEAT_POINTS);
	    System.out.println(this.p1 + " wins");
	}
    }
}
