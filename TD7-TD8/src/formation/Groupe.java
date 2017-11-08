
package formation;

import java.util.*;

/**
 * Classe Groupe : définition d'un groupe d'étudiants d'une même formation par
 * un tableau associatif dont la clé est le NIP de l'étudiant.
 */
public class Groupe {
    /** son nom */
    private String sonNom;
    /** ses étudiants */
    private Set<Etudiant> sesEtudiants;
    /** le nom de sa formation */
    private Formation formation;

    /**
     * Construit un groupe vide dont le nom et le nom de la formation sont
     * passés en paramètre.
     */
    public Groupe(String nom, Formation Formation) {
	this.sesEtudiants = new HashSet<Etudiant>();
	this.formation = Formation;
	this.sonNom = nom;
    }

    /**
     * Ajoute l'étudiant passé en paramètre au groupe, *
     * 
     * @param e
     *            l'étudiant à ajouter au groupe.
     */
    public void ajoutEtudiant(Etudiant e) {
	this.sesEtudiants.add(e);
    }

    /**
     * Supprime l'étudiant passé en paramètre du groupe, s'il est présent.
     * 
     * @param e
     *            l'étudiant à supprimer du groupe.
     * @throws IllegalStateException
     *             si l'étudiant n'appartient pas au groupe.
     */
    public void suppressionEtudiant(Etudiant e) {
	this.sesEtudiants.remove(e);
    }

    /**
     * retourne un iterateur sur ce groupe.
     * 
     * @return un itérateur permettant de parcourir ce groupe.
     */
    public Iterator<Etudiant> iterator() {
	return sesEtudiants.iterator();
    }

    /**
     * Calcule la moyenne du groupe pour la matière dont le nom est passé en
     * paramètre.
     * 
     * @param matiere
     *            le nom de la matiere
     * @return la moyenne du groupe pour la matière dont le nom est passé en
     *         paramètre.
     */
    public float moyenneMatiere(Matiere matiere) {
	float somme = 0;
	for (Etudiant etudiant : this.sesEtudiants)
	    try {
		somme += etudiant.moyenneMatiere(matiere);
	    } catch (IllegalStateException e) {
	    }
	return somme / this.sesEtudiants.size();
    }

    /**
     * Retourne une liste des étudiants triés selon un,comparateur fourni
     *  @param comp le comparateur utilisé pour le tri
     *  @return la liste des étudiants de ce groupe triée selon le compaarateur fourni
     */
    private List<Etudiant> tri(Comparator<Etudiant> comp) {
	List<Etudiant> listeEtud = new LinkedList<Etudiant>(sesEtudiants);
	// trie selon l'ordre croissant induit par le comparator en paramètre
	Collections.sort(listeEtud, comp);
	return listeEtud;
    }

    /**
     * Retourne une liste des étudiants triés sur leur nom par ordre
     * alphabétique croissant.
     */
    public List<Etudiant> triAlphabetique() {
	return this.tri(new ComparateurNom());
    }
    /**
     * Retourne une liste des étudiants triés par mérite (selon l'ordre de leur
     * moyenne générale décroissante).
     */
    public List<Etudiant> triParMerite() {
	return this.tri(new ComparateurMoyGale());
    }
	
}
