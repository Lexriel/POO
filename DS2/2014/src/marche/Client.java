package marche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client{

    /** collecte les commandes en attente pour ce client en associant à un identifiant sa commande
     */
    private Map<Identifiant, Commande> commandesEnAttente;
    /** collecte les commandes traitees pour ce client en associant à un identifiant sa commande
     */
    private Map<Identifiant,Commande> commandesTraitees;
    /** associe l'identifiant d'une commande au fournisseur qui l'a traitée
     */
    private Map<Identifiant, Fournisseur> fournisseurCommandes;
	
    /**
     * crée un client, initialement il n'a aucune commande en attente ni traitées
     */
    public Client(){
	this.commandesEnAttente = new HashMap<Identifiant, Commande>();
	this.commandesTraitees = new HashMap<Identifiant, Commande>();
	this.fournisseurCommandes = new HashMap<Identifiant, Fournisseur>();
    }
	
    /** fournit les commandes en attente pour ce client
     * @return la liste des commandes en attente pour ce client
     */
    public List<Commande> getCommandesEnAttente(){
	return new ArrayList<Commande>(this.commandesEnAttente.values());
    }

    /** ajoute une nouvelle commande en attente pour ce client
     * @param commande la nouvelle commande
     */
    public void nouvelleCommande(Commande commande){
	this.commandesEnAttente.put(commande.getId(),commande);
    }

    /** indique qu'une commmande en attente est traitée par un fournisseur. 
     * Cette commande est retirée des commandes et passe dans les commandes traitees.
     * @param commande la commande traitee
     * @param fournisseur le fournisseur qui traite la commande
     */
    public void commandeTraiteePar(Commande commande, Fournisseur fournisseur){
	this.fournisseurCommandes.put(commande.getId(),fournisseur);			// la commande est traitée par 'fournisseur' 
	this.commandesTraitees.put(commande.getId(),commande);					// ajoute la commande aux ommandes traitées
	this.commandesEnAttente.remove(commande.getId());						// la commande n'est plus en attente de traitement
    }
	
    /** fournit la liste des commandes traitees pour un fournisseur donné
     * @param fournisseur le fournisseur concerné
     * @return fournit la liste des commandes traitees par fournisseur
     */
    public List<Commande> commandesTraiteesParFournisseur(Fournisseur fournisseur){
	List<Commande> resultat = new ArrayList<Commande>();
	for(Identifiant id : this.commandesTraitees.keySet()){					// parmi toutes les commandes traitées
	    if (this.fournisseurCommandes.get(id).equals(fournisseur)){        // si le fournisseur de la commande est celui recherché
		resultat.add(this.commandesTraitees.get(id));					// on garde la commande pour le résultat 
	    }
	}
	return resultat;
    }
}
