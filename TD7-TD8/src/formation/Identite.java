package formation;

/**
 * Classe Identite : identité d'un étudiant, définie par un NIP, un nom et un
 * prénom.
 */
public class Identite {
    /** son NIP. */
    private String nip;
    /** son nom. */
    private String nom;
    /** son prénom. */
    private String prenom;

    /**
     * construit l'Identite d'une personne dont les NIP, le nom et le prénom
     * sont passés en paramètre.
     * 
     * @param nip
     *            le NIP de cette personne
     * @param prenom
     *            le prénom de cette personne
     * @param nom
     *            le nom de cette personne
     */
    public Identite(String nip, String prenom, String nom) {
	this.nip = nip;
	this.prenom = prenom;
	this.nom = nom;
    }

    /**
     * Retourne le NIP de cette Identite.
     * 
     * @return le NIP de cette identite
     */
    public String getNip() {
	return this.nip;
    }

    /**
     * Retourne le nom de cette personne.
     * 
     * @return le nom de cette personne
     */
    public String getNom() {
	return this.nom;
    }

    /**
     * Retourne le prénom de cette personne.
     * 
     * @return le prénom de cette personne
     */
    public String getPrenom() {
	return this.prenom;
    }

    /**
     * Retourne vrai si cette identité est identique à l'objet passé en
     * paramètre, c'est à dire si leur NIP sont égaux.
     * 
     * @param o
     *            l'objet à comparer à cette Identite
     */
    public boolean equals(Object o) {
	try {
	    Identite i = (Identite) o;
	    return this.nip.equals(i.nip);
	} catch (ClassCastException e) {
	    return false;
	}
    }

    /**
     * retourne une version String de cette identité.
     * 
     * @return une version String de cette identité
     */
    public String toString() {
	return new String("NIP : " + this.getNip() + " , nom : " + this.getNom()
			  + " , prénom : " + this.getPrenom());
    }
	
    /** le hashCode de cette identité
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
	return this.nip.hashCode();
    }
	
}
