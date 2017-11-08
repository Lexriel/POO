package hanoi;

import hanoi.util.*;
import io.*;

public class Hanoi {

    private Tower[] theTowers;

    private int capacity;

    public Hanoi(int capacity) {
	this.capacity = capacity;
	this.theTowers = new Tower[3];
	for (int i = 0; i < 3; i++) {
	    this.theTowers[i] = new Tower(capacity);
	}
	for (int k = capacity; k > 0; k--) {
	    this.theTowers[0].push(new Disc(k));
	}
    }

    public void execute() {
	this.display();
	this.move(this.capacity, 0, 2);
    }

    public void moveOneDisc(int source, int destination) {
	this.theTowers[destination].push(this.theTowers[source].pop());
	this.display();
    }

    public void move(int nb, int source, int destination) {
	if (nb == 1)
	    this.moveOneDisc(source, destination);
	else {
	    this.move(nb - 1, source, 3 - source - destination);
	    this.moveOneDisc(source, destination);
	    this.move(nb - 1, 3 - source - destination, destination);
	}
    }

    private static String repeatChar(char c, int n){
	String s = new String();
	for (int i=0; i<n; i++)
	    s += c;
	return s;
    }

    public boolean victory(){
	if (this.theTowers[0].getNbDiscs() != 0)
	    return false;
	if (this.theTowers[1].getNbDiscs() != 0)
	    return false;
	return true;
    }

    public String toString(){
	String res = new String();
	for(int k=this.capacity-1; k>=0; k--){
	    for (int i=0; i<3; i++){
		if (k <this.theTowers[i].getNbDiscs()){
		    int size = this.capacity - this.theTowers[i].getTheDiscs(k).getTaille();
		    res += repeatChar(' ', size);
		    res += this.theTowers[i].getTheDiscs(k);
		    res += repeatChar(' ', size);
		}
		else{
		    int size = this.capacity;
		    res += repeatChar(' ', size) + "|" + repeatChar(' ', size);
		}
	    }
	    res += "\n";
	}
	return res;
    }


    public void display() {
	System.out.println("*************");
	System.out.println(this);
	// System.out.println("*************");
	// System.out.println("TOWER #1 \n");
	// System.out.println(this.theTowers[0]);
	// System.out.println("TOWER #2 \n");
	// System.out.println(this.theTowers[1]);
	// System.out.println("TOWER #3 \n");
	// System.out.println(this.theTowers[2]);
    }
}
