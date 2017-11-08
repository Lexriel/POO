/*
 * Created on 11 mars 2005
 *
 */
package afficheur;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 
 */

public class LedDisplayer{

    protected char[] message;
    protected Decaleur decaleur;
    protected int indexCourant;  // pour retenir à quel caractère du message on est arrivé

    /**
     * Constructeur de LedDisplayer
     */
    public LedDisplayer(int tailleAffichage){
	this.decaleur = new Decaleur(tailleAffichage);
    }

    /** sets the new message to display
     * @param message the new message
     */
    public void setMessage(String message){      
	this.message = message.toCharArray();
	this.indexCourant = 0;
    }

    /** shift message by one character on the left */
    public void shift(){
	this.decaleur.decale(this.message[this.indexCourant]);
	this.indexCourant = (this.indexCourant + 1) % this.message.length;
    }

    public String toString(){
	return this.decaleur.toString();
    }

    /** returns the text that appears on the screen
     * @return the text that appears on the screen
     */
    public String textOnScreen(){
	return this.toString();
    }
}
