/*
 * Created on 11 mars 2005
 *
 */
package afficheur;

/**
 * @author <a href="mailto:routier@lifl.fr">routier</a>
 */

public class DisplayerWithLatency extends LedDisplayer{

    private int latence;
   
    /**
     * @param tailleAffichage
     */
    public DisplayerWithLatency(int tailleAffichage, int latence){
	super(tailleAffichage);
	this.latence = latence;
    }
   
    /**
     * Obtenir la latence revient à ajouter <t>latence</t> espaces en
     * fin de message (on aurait pu gérer cela au niveau de shift() )
     * @see afficheur.LedDisplayer#setMessage(char[])
     */
    public void setMessage(String msg){
	String messageAvecLatence = msg;
	for(int i=0; i<this.latence; i++)
	    messageAvecLatence = messageAvecLatence +" ";
	super.setMessage(messageAvecLatence);
    }   
}
