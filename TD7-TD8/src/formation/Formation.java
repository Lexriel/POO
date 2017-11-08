package formation;

import java.util.*;

/**
 * Classe Formation : formation d'un étudiant, définie par un identifiant, et
 * une liste de couples (matière, coeff) implantée par une Map. La clé de ce
 * tableau associatif est le nom de la matière, de type Matiere qui est une
 * énumération, l'objet associé est son coefficient (un entier).
 */
public class Formation {
    /** son nom */
    private String sonNom;
    /** ses matières */
    private Map<Matiere, Integer> sesMatieres;

    /**
     * Construit une formation dont l'identifiant est passé en
     * paramètre.
     * @param nom le nom de cette formation */
    public Formation(String nom) {
	this.sonNom = nom;
	this.sesMatieres = new HashMap<Matiere, Integer>();
    } // Formation

    /*************** ACCESSEURS EN LECTURE ***************************/

    /**
     * retourne le coefficient de la matière dont le nom est passé en paramètre.
     * @param matiere le nom de la matière dont on veut le coefficient
     * @return le coefficient de la matière dont le nom est passé en paramètre
     * @throws IllegalStateException , si la matière n'existe pas */
    public int coeffMatiere(Matiere matiere) throws IllegalStateException {
	if (this.matiereExiste(matiere))
	    return this.sesMatieres.get(matiere);
	else {
	    throw new IllegalStateException("la matiere " + matiere
					    + " n'existe pas ds la formation " + this.sonNom);
	}
    }

    /** retourne le nom de cette formation.
     * @return le nom de cette formation. */
    public String getNom() {
	return this.sonNom;
    }

    /** retourne l'ensemble des matieres de cette formation.
     * @return l'ensemble des matières de cette formation. */
    /* Set<E>: Interface héritant de Collection */
    public Set<Matiere> matieres() {
	return this.sesMatieres.keySet();
    }

    /** retourne vrai si la matière dont le nom est passé en paramètre
     * appartient à cette formation
     * @param matiere le nom de cette matière */
    public boolean matiereExiste(Matiere matiere) {
	return this.sesMatieres.containsKey(matiere);
    }

    /******************** MODIFICATEURS ******************/

    /**
     * Ajoute à cette formation une matière dont le nom et le coefficient sont
     * passés en paramètre, si elle n'est pas déjà présente.
     * @param matiere le nom de la matiere
     * @param coeff le coefficient de cette matière
     * @throws IllegalStateException , si la matière existe déjà */
    public void ajoutMatiere(Matiere matiere, int coeff)
	throws IllegalStateException {
	// on regarde si la matière existe
	if (this.matiereExiste(matiere))
	    throw new IllegalStateException("la matiere " + matiere
					    + " existe déjà ds la formation " + this.sonNom);
	else
	    this.sesMatieres.put(matiere, coeff);
    } // ajoutMatiere()

    /** Modifie ds cette formation le coefficient associé à la matière dont le
     * nom est passé en paramètre.
     * @param matiere le nom de cette matière
     * @param coeff le coefficient de cette matière
     * @throws IllegalStateException , si la matière n'existe pas */
    public void modifCoeff(Matiere matiere, int coeff)
	throws IllegalStateException {
	if (this.matiereExiste(matiere))
	    this.sesMatieres.put(matiere, coeff);
	else
	    throw new IllegalStateException("la matiere " + matiere
					    + " n'existe pas ds la formation " + this.sonNom);
    }

    /** Supprime de cette formation la matière dont le nom est passé en
     * paramètre.
     * @param matiere le nom de la matière à supprimer
     * @throws IllegalStateException , si la matière n'existe pas */
    public void suppressionMatiere(Matiere matiere)
	throws IllegalStateException {
	if (this.matiereExiste(matiere))
	    this.sesMatieres.remove(matiere);
	else
	    throw new IllegalStateException("la matiere " + matiere
					    + " n'existe pas ds la formation " + this.sonNom);
    }

    /********************* POUR AFFICHAGE ******************************/

    /** retourne une version String de cette formation.
     * @return une version String de cette formation. */
    public String toString() {
	return new String("Formation " + this.sonNom + " : "
			  + this.sesMatieres.toString());
    }

    public static void main(String[] arg) {
	Formation f = new Formation("licence");
	f.ajoutMatiere(Matiere.ASD, 3);
	System.out.println(f.toString());
	f.ajoutMatiere(Matiere.POO, 3);
	System.out.println(f.toString());
	f.modifCoeff(Matiere.POO, 4);
	System.out.println("PO : " + f.coeffMatiere(Matiere.POO));
	System.out.println("ASD : " + f.coeffMatiere(Matiere.ASD));
	System.out.println(f.toString());
    }
}
