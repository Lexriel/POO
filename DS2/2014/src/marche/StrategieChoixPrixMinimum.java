package marche;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Stratégie de choix de commande qui n'accepte que des commandes au dessus d'un prix minimum donné
 * @author JC
 *
 */
public class StrategieChoixPrixMinimum implements StrategieChoix{

    /** le prix minimum des comandes acceptées */
    private float prixMin;
    /** crée une stratégie avec un peix minimum pour les commandes acceptées
     * @param prixMin le prix minimum accepté
     */
    public StrategieChoixPrixMinimum(float prixMin){
	this.prixMin = prixMin;
    }

    private static Random alea = new Random();
    /** n'accepte que des commandes au dessus du prix minimum, un choix au hasard parmi celle-ci est fait
     * @see marche.StrategieChoix#choisit(java.util.List)
     */
    public Commande choisit(List<Commande> commandes) throws PasDeCommandeException{
	List<Commande> select = new ArrayList<Commande>(); // sélection des commandes
	for(Commande c : commandes){
	    if (c.getPrix() > prixMin)                     // au-dessus du prix minimum
		select.add(c);
	}

	if (select.isEmpty())
	    throw new PasDeCommandeException();
	int nb = alea.nextInt(select.size());              // on retient une commande	
	return select.get(nb);                             // au hasard dans la sélection
    }
}
