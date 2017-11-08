package hanoi.util;

// Pas de levee d'exception
public class Tower {

    private Disc[] theDiscs;
    private int capacity;
    private int nbDisc;

    public Tower(int capacity) {
	this.capacity = capacity;
	this.theDiscs = new Disc[capacity];
	this.nbDisc = 0;
    }

    public int getCapacite() {
	return this.capacity;
    }

    public int getNbDiscs() {
	return this.nbDisc;
    }

    public boolean isFull() {
	return this.capacity == this.nbDisc;
    }

    public boolean isEmpty() {
	return this.nbDisc == 0;
    }

    /** return null si la tour est vide */
    public Disc top() {
	if (!this.isEmpty()) {
	    return this.theDiscs[this.nbDisc - 1];
	} else {
	    return null;
	}
    }

    /** ne change pas l'etat de la tour si la tour est pleine */
    public void push(Disc d) {
	if (!this.isFull()) {
	    this.theDiscs[this.nbDisc] = d;
	    this.nbDisc++;
	}
    }

    /** return null si la tour est vide */
    public Disc pop() {
	if (!this.isEmpty()) {
	    this.nbDisc--;
	    return this.theDiscs[this.nbDisc];
	} else {
	    return null;
	}
    }
    
    public String toString() {
	String result = "";
	for (int i = this.nbDisc; i > 0; i--) {
	result += this.theDiscs[i - 1] + "\n";
	}
	return result;
    }

    public Disc getTheDiscs(int k){
	    return this.theDiscs[k];

    }

    // public String discString(int k) {
    // 	String result = "";
    // 	int size = this.capacity - this.theDiscs[k].getTaille();
    // 	result += repeatChar(' ', size) + this.theDiscs[k];
    // 	result += repeatChar(' ', size);
    // 	return result;
    // }

}
