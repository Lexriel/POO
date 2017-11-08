package hc;

/**
 * @author <a href="mailto:jean-christophe.routier@univ-lille1.fr">routier</a>
 * 
 */

public class EtudiantTroisiemeCycle extends EnseignantExterieur{

    private static final int SERVICE_MAX = 96;
    private static final float DIMINUTION_CAR_PAS_EMPLOYEUR = 0.82f;
    /**
     * @param name
     */
    public EtudiantTroisiemeCycle(String name, int heuresEffectuees){
	super(name, heuresEffectuees);   
    }

    /** heures complémentaires = toutes les heures à hauteur de SERVICE_MAX h
     * @see hc.Enseignant#heuresComplementaires()
     */
    public int heuresComplementaires(){
	return Math.min(this.heuresEffectuees, EtudiantTroisiemeCycle.SERVICE_MAX);
    }
   
    /** diminution car pas d'employeur principal
     * @see hc.Enseignant#retribution()
     */
    public float retribution(){
	return EtudiantTroisiemeCycle.DIMINUTION_CAR_PAS_EMPLOYEUR * super.retribution();
    }
}
