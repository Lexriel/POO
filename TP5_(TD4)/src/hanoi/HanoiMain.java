package hanoi;

import hanoi.util.*;
import io.*;

public class HanoiMain{

    public static void main(String[] args){
	if (args.length > 0) {
	    try{
		System.out.println("Les trois tours son désignées respectivement par les lettres");
		System.out.println("g comme GAUCHE , c comme CENTRE et d comme DROITE. Pour effectuer");
		System.out.println("un déplacement, il faut taper le mot de deux lettres correspondant");
		System.out.println("à tour de départ tour d'arrivée. Par exemple en tapant gc, on déplace le");
		System.out.println("disque au sommet de la tour gauche sur la tour centrale.");
		System.out.println("On peut quitter en tapant quit");
		Hanoi game=new Hanoi(Integer.parseInt(args[0]));
		HanoiInput user = new HanoiInput();
		boolean win = false;
		int n = 0;
		game.display();
		try{
		    while (!win){
			user.readInput();
			int src = user.getFrom();
			int dest = user.getTo();
			game.moveOneDisc(src, dest);
			win = game.victory();
			n++;
		    }
		}
		catch(IllegalStateException e){
		    System.out.println("********************************************");
		    System.out.println("Vous quittez la partie après " + n + " coups.");
		}
		if (win){
		    System.out.println("********************************************");
		    System.out.println("Félicitations !\nVous avez gagné en " + n + " coups.");
		}
	    }
	    catch(NumberFormatException e){
		System.out.println("Usage :\n 'java hanoi.Hanoi N' ou N est le nombre de disques sur la tour de depart");
	    }
	}
	else{
	    System.out.println("Usage :\n 'java hanoi.Hanoi N' ou N est le nombre de disques sur la tour de depart");
	}
    }

}
