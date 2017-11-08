
package formation;

import java.util.*;

/**
 * Classe ComparateurMoyGale : comparateur définissant qu'un étudiant est plus
 * petit qu'un autre si sa moyenne générale est plus grande.
 */
public class ComparateurMoyGale implements Comparator<Etudiant> {

    public int compare(Etudiant e1, Etudiant e2) {		
	if (e1.moyenne() < e2.moyenne())
	    return 1;
	else if (e1.moyenne() == e2.moyenne())
	    return 0;
	else
	    return -1;
    }
}
