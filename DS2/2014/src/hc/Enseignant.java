
package hc;

/**
 * @author <a href="mailto:jean-christope.routier@univ-lille1.fr">routier</a>
 * 
 */

public abstract class Enseignant{
   
    private static float TAUX_HORAIRE = 45;
   
    /**
     * @param name nom de l'enseignant 
     * @param heuresEffectuees TODO
     */
    public Enseignant(String name, int heuresEffectuees){
	this.name = name;
	this.heuresEffectuees = heuresEffectuees;
    }

    /**
     *  le nom de l'enseignant
     */
    protected String name;

    /**
     *  nombre d'heures d'enseignement effectuées
     */
    protected int heuresEffectuees;

    /** retourne le nom de l'enseignant
     * @return le nom de l'enseignant
     */
    public String getNom(){
	return this.name;
    }

    /** retourne le nombre d'heures complémentaires effectuées
     * @return le nombre d'heures complémentaires effectuées
     */
    public abstract int heuresComplementaires();

    /**
     * @return the heuresEffectuees
     */
    public int getHeuresEffectuees(){
	return this.heuresEffectuees;
    }

    /** retourne la rémunération qui correcpond au nombre d'hc effectuées
     * @return la rémunération qui correcpond au nombre d'hc effectuées
     */
    public float retribution(){
	return this.heuresComplementaires() * Enseignant.TAUX_HORAIRE;
    }
}
