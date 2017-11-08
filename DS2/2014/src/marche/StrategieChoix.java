package marche;

import java.util.List;

/** Définit une tratégie de choix de commande pour les fournisseurs
 * @author JC
 *
 */
public interface StrategieChoix{

    /** choisit une commande dans la liste selon 
     * @param commandes la liste des commandes
     * @return la commande choisie
     * @throws PasDeCommandeException, si aucune commande ne peut être choisie
     */
    public Commande choisit(List<Commande> commandes) throws PasDeCommandeException;
}
