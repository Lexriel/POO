package marche;

import java.util.*;

public class Fournisseur{

    /** la stratégie de choix de commande */
    private StrategieChoix strategie;
	
    /** le chiffre d'affaires de ce fournisseur */
    private float chiffreAffaires;
    /** les commandes tratités par ce fournisseur */
    private List<Commande> commandesTraitees;
	
    /** crée un fournisseur avec un stratégie de choix de commande 
     * @param strategie la stratégie de choix de commande pour ce fournisseur
     */
    public Fournisseur(StrategieChoix strategie){
	this.strategie = strategie;
	this.chiffreAffaires = 0;
	this.commandesTraitees = new ArrayList<Commande>();
    }
	
    /** sélectionne l'une des commandes en attente pour le client selon la stratégie de choix
     * et traite cette commande, le chiffre d'affaires est modifié en conséquence
     * Si aucune commande n'est disponible auprès du client, une maintenance est déclenché.
     * @param client le client dont on traite la commande
     */
    public void choisitEtTraiteCommande(Client client){
	Commande choisie;
	try{					
	    // sélection d'une commande du client par la stratégie
	    choisie = this.strategie.choisit(client.getCommandesEnAttente());
	    // on informe le client que ce fournisseur traite la commande
	    client.commandeTraiteePar(choisie, this);
	    // ajout aux commandes traitees
	    this.commandesTraitees.add(choisie);
	    this.augmenteChiffreAffaires(choisie.getPrix());
	    this.produitCommande(choisie);		
	}
	catch (PasDeCommandeException e){ // aucune commande n'a été choisie ?
	    this.maintenance();
	}		
    }

    private void produitCommande(Commande choisie){
	// TODO Auto-generated method stub	
    }

    private void maintenance(){
	// nop
    }

    public float getChiffreAffaires(){
	return this.chiffreAffaires;
    }

    public void augmenteChiffreAffaires(float chiffreAffaires){
	this.chiffreAffaires = this.chiffreAffaires + chiffreAffaires;
    }
}
