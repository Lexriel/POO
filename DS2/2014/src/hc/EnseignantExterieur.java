package hc;

/**
 * @author <a href="mailto:jean-christophe.routier@univ-lille1.fr">routier</a>
 * 
 */

public class EnseignantExterieur extends Enseignant{

    /**
     * @param name
     */
    public EnseignantExterieur(String name, int heuresEffectuees){
	super(name, heuresEffectuees);
    }

    /** toutes le heures sont complémentaires
     * @see hc.Enseignant#heuresComplementaires()
     */
    public int heuresComplementaires(){
	return this.heuresEffectuees;
    }
}
