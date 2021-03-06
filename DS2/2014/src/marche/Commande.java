package marche;

public class Commande{

    /** identifiant (unique) de la commande */
    private final Identifiant id;					
    /** prix de la commande */
    private float prix;								

    /** crée une commande et lui attribue un identifiant unique
     * @param prix le prux de cette commande
     */
    public Commande(float prix){
	this.prix = prix;
	this.id = Identifiant.genereIdentifiant(); 	// génération de l'identifiant unique à la création de l'instance
    }

    /**
     * @return le prix de la commande
     */
    public float getPrix(){
	return this.prix;
    }

    /**
     * @return l'identifiant (unique) de la commande
     */
    public Identifiant getId(){
	return this.id;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode(){
	return this.id.hashCode();					// l'identifiant est supposé unique dpnc discriminant pourle hashcode
    }
	
    /** deux commandes sont égales si elles ont le même identifiant
     * @see java.lang.Object#equals(java.lang.Object)
     */
    // a priori avec la génération d'identifiant unique dans le constructeur on pourrait utiliser == en fait
    public boolean equals(Object o){
	if (o instanceof Commande)
	    return this.id.equals(((Commande) o).id);
	return false;
    }
}
