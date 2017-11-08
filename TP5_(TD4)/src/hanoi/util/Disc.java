package hanoi.util;

public class Disc {

    private int taille;

    public Disc(int t){
	this.taille=t;
    }

    public int getTaille(){
	return this.taille;
    }

    public String toString(){
	// return ""+this.taille;
	String s = new String();
	for (int i=0; i<this.taille; i++)
	    s += "_";
	return s + "|" + s;
    }
}
