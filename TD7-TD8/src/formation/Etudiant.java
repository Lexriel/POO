package formation;

import java.util.*;

/**
 * Classe Etudiant : définition d'un étudiant, par son identité, sa formation et
 * la liste de ses notes par matières.
 */
public class Etudiant {
    /** son identité. */
    private Identite identite;

    /** sa formation. */
    private Formation saFormation;
    /** ses notes : couples (matière,liste de notes). */
    private Map<Matiere,List<Float>> sesNotes;

    /**
     * Construit un etudiant à partir de son identité et sa formation
     * 
     * @param id
     *            l'identité de cet étudiant
     * @param formation
     *            la formation de cet étudiant
     */
    public Etudiant(Identite id, Formation formation) {
	this.identite = id;
	this.saFormation = formation;
	// on construit une liste de notes vide pour chaque matière de
	// la formation
	this.sesNotes = new HashMap<Matiere,List<Float>>();
	for (Matiere matiere : this.saFormation.matieres())
	    this.sesNotes.put(matiere,	new ArrayList<Float>());
    }

    /********************* ACCèSSEURS *******************************/


    /**
     * Retourne vrai si la matière dont le nom est passé en paramètre appartient
     * à la formation de l'étudiant.
     * 
     * @param matiere
     *            le nom de la matière cherchée
     * @return vrai si la matière passée en paramètre appartient à la formation
     *         de l'étudiant.
     */
    public boolean appartientFormation(Matiere matiere) {
	return this.sesNotes.containsKey(matiere);
    }

    /**
     * Retourne la liste des notes de cet étudiant ds la matière dont le nom est
     * passé en paramètre.
     * 
     * @param matiere
     *            le nom de la matière
     * @return la liste des notes de cet étudiant pour cette matière
     */
    public List<Float> notesMatiere(Matiere matiere) {
	return this.sesNotes.get(matiere);
    }

    /**
     * Retourne l'ensemble des matières de cet étudiant.
     * 
     * @return l'ensemble des matières de cet étudiant.
     */
    public Set<Matiere> matieres() {
	return this.saFormation.matieres();
    }

    /**
     * retourne l'identité de cet étudiant.
     * 
     * @return l'identité de cet étudiant
     */
    public Identite identite() {
	return this.identite;
    }

    /**
     * retourne le nom de cet étudiant.
     * 
     * @return le nom de cet étudiant
     */
    public String nom() {
	return this.identite.getNom();
    }

    /** retourne la formation de cet étudiant
     * @return la formation de cet étudiant
     */
    public Formation getSaFormation() {
	return saFormation;
    }
    /**
     * retourne vrai si cet étudiant et l'objet passé en paramètre sont
     * identiques.
     * 
     * @param o
     *            l'objet à comparer à cet étudiant
     * @return vrai si cet étudiant et l'étudiant passé en paramètre ont la même
     *         identité.
     */
    public boolean equals(Object o) {
	try {
	    Etudiant e = (Etudiant) o;
	    return e.identite().equals(e.identite());
	} catch (ClassCastException ex) {
	    return false;
	}
    }

    /**
     * Retourne une valeur de hachage pour cet étudiant.
     * this.identite est un String donc le hashcode appelé est celui
     * de la classe String.
     *  ____      ______      ______
     * | 11 | -> | 153M | -> | 228F | ->
     * |____|    |______|    |______|
     * | 12 | -> ...
     * |____|
     * |    | -> ...
     * |____|
     * |    |
     * |____|
     * valeurs de hachage
     *
     * Il y a beaucoup d'étudiants, rechercher un étudiant dans une
     * grande liste est fastidieux, mais si on calcule sa valeur de
     * hachage, on y accède quasi directement, il y moins d'éléments à
     * parcourir. On recoure à une recherche par hachage sur le nip.
     *
     * @return le NIP de cet étudiant.
     */
    public int hashCode() {
	return this.identite.hashCode();
    }

    /******************* MODIFICATEURS **************************/

    /**
     * Ajoute à cet étudiant une note pour la matière passée en paramètre.
     * 
     * @param note
     *            la note à ajouter.
     * @param matiere
     *            le nom de la matière concernée.
     * @throws IllegalStateException
     *             si la matière n'existe pas ds la formation de cet étudiant
     */
    public void ajoutNote(Matiere matiere, float note)
	throws IllegalStateException {
	// on regarde si la matière existe ds la formation
	if (this.appartientFormation(matiere)) {
	    // on récupère la liste de notes pour
	    // cette matière
	    List<Float> notesMatiere = this.notesMatiere(matiere);
	    // on ajoute cette note à la liste
	    notesMatiere.add(note);
	} else
	    throw new IllegalStateException("la matiere " + matiere
					    + " n'existe pas ds la formation " + this.saFormation.getNom()
					    + " de l'étudiant de NIP " + this.identite.getNip());
    } // ajoutNote

    /**************************** MOYENNES ********************************/

    /**
     * calcule la moyenne de cet étudiant pour la matière dont le nom est passé
     * en paramètre.
     * 
     * @param matiere
     *            le nom de la matière dont on veut la moyenne des notes
     * @return la moyenne de cet étudiant pour la matière dont le nom est passé
     *         en paramètre.
     * @throws IllegalStateException
     *             si l'étudiant n'a aucune note de cette matière ou si la
     *             matière n'appartient pas à la formation.
     */
    public double moyenneMatiere(Matiere matiere) throws IllegalStateException {
	if (!this.appartientFormation(matiere))
	    throw new IllegalStateException("la matiere " + matiere
					    + " n'existe pas ds la formation " + this.saFormation.getNom()
					    + " de l'étudiant de NIP " + this.identite.getNip());
	else {
	    List<Float> notesMatiere = this.notesMatiere(matiere);
	    if (notesMatiere.isEmpty())
		throw new IllegalStateException("L'étudiant de NIP "
						+ this.identite.getNip() + "n'a aucune note en " + matiere);
	    else {
		float somme = 0;
		for (Float note : notesMatiere)
		    somme = somme + note;
		return somme / notesMatiere.size();
	    }
	}
    } // moyenneMatiere

    /**
     * calcule la moyenne globale de cet étudiant.
     * 
     * @throws IllegalStateException
     *             si l'étudiant n'a aucune note
     */
    public float moyenne() throws IllegalStateException {
	int sommeCoeff = 0;
	float sommeTotale = 0;
	for (Matiere matiere : this.matieres()) {
	    int coeffMatiere = this.saFormation.coeffMatiere(matiere);
	    try {
		sommeTotale += this.moyenneMatiere(matiere) * coeffMatiere;
		sommeCoeff += coeffMatiere;
	    } catch (IllegalStateException e) {
		// pas de note ? on ne la compte pas
	    }
	}
	return sommeTotale / sommeCoeff;
    } // moyenneMatiere

    /******************************* POUR AFFICHAGE ********************************/

    /**
     * retourne une version String de cet étudiant.
     * 
     * @return une version String de cet étudiant
     */
    public String toString() {
	String res = new String(this.identite.toString() + " , formation : "
				+ this.saFormation.getNom() + "moyenne gale : ");
	try {
	    float m = this.moyenne();
	    res = res + m;
	} catch (IllegalStateException e) {
	}
	return res;
    }

    /**
     * retourne une version String détaillée de cet étudiant.
     * 
     * @return une version String détaillée de cet étudiant
     */
    public String toStringDetails() {
	return new String(this.toString() + "\n" + this.notesString());
    }

    /**
     * retourne une version String des notes de cet étudiant.
     * 
     * @return une version String des notes de cet étudiant
     */
    public String notesString() {
	Iterator<Matiere> iterMatieres = this.matieres().iterator();
	Matiere matiere = null;
	String res = "";
	while (iterMatieres.hasNext()) {
	    matiere = iterMatieres.next();
	    res = res.concat(matiere + " : "
			     + this.notesMatiere(matiere).toString() + "\n");
	}
	return res;
    } // toStringDetails()

    public static void main(String[] arg) {
	Formation licence = new Formation("licence");
	licence.ajoutMatiere(Matiere.ASD, 3);
	licence.ajoutMatiere(Matiere.POO, 3);
	licence.ajoutMatiere(Matiere.AEL, 2);
	Etudiant e = new Etudiant(new Identite("123", "Tim", "Oleon"), licence);
	e.ajoutNote(Matiere.ASD, 10.0f);
	e.ajoutNote(Matiere.ASD, 3.0f);
	e.ajoutNote(Matiere.POO, 13.0f);
	System.out.println(e.toStringDetails());
	System.out.println("Moyenne de ASD : " + e.moyenneMatiere(Matiere.ASD));
	System.out.println("Moyenne de PO : " + e.moyenneMatiere(Matiere.POO));
	System.out.println("Moyenne totale : " + e.moyenne());
    }

}
