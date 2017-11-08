package formation;

import java.util.*;

/**
 * Classe ComparateurNom : comparateur définissant qu'un étudiant est plus petit
 * qu'un autre si son nom est plus petit pour l'ordre alphabétique.
 */
public class ComparateurNom implements Comparator<Etudiant> {

    public int compare(Etudiant e1, Etudiant e2) {
	return e1.nom().compareTo(e2.nom());
    }
}
