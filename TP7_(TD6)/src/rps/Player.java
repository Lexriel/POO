package rps;

public class Player{

    private String name;
    private int points;
    private Strategy myStrategy;

    public Player(String name, Strategy s){
	this.name = name;
	this.points = 0;
	this.myStrategy = s;
    }

    public String getName(){
	return this.name;
    }

    public String toString(){
	return "Player " + this.name;
    }

    public int getScore(){
	return this.points;
    }

    public void addPoints(int p){
	this.points = this.points + p;
    }

    public Shape play(){
	return this.myStrategy.chooseShape();
    }
}
