/*
 * Created on 11 mars 2005
 *
 */
package afficheur;

/**
 * Classe SpeedDisplayer
 */
public class SpeedDisplayer extends DisplayerWithLatency{

    private int vitesse;

    /**
     * @param tailleAffichage
     */
    public SpeedDisplayer(int tailleAffichage, int latence, int vitesse){
	super(tailleAffichage, latence);
	this.vitesse = vitesse;
    }

    /**
     * @see afficheur.LedDisplayer#shift()
     */
    public void shift(){
	for(int i=0; i<this.vitesse; i++)
	    super.shift();
    }
}
