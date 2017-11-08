package marche;

import java.util.List;

/** stratégie de choix de commande qui retient une des commandes avec le prix le plus élevé
 * (favorise le chiffre d'affaires)
 * @author JC
 *
 */
public class StrategieChoixMeilleurPrix implements StrategieChoix{

	
    /** retient une des commandes avec le prix le plus élevé
     * @see marche.StrategieChoix#choisit(java.util.List)
     */
    public Commande choisit(List<Commande> commandes) throws PasDeCommandeException{
	if (commandes.isEmpty())
	    throw new PasDeCommandeException();
	float meilleurPrix = 0;
	Commande result = null;
	for (Commande cmde : commandes){
	    if (cmde.getPrix() > meilleurPrix){
		meilleurPrix = cmde.getPrix();
		result = cmde;
	    }
	}
	return result;
    }
}
