package taquin;

import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// creation
		Taquin taquin = new Taquin(4,3);
		taquin.affiche();
		// bien ranges et cases en place
		System.out.println("bien range ?"+taquin.estMotifParticulier());
		System.out.println("nb en places ?"+taquin.nbCasesEnPlace());		
		
		// test deplacement
		try {
			taquin.deplacement(DirectionDeplacement.gauche);
		} catch (DeplacementImpossibleException e) {
			e.printStackTrace();
		}		
		
		taquin.affiche();
		System.out.println("bien range ?"+taquin.estMotifParticulier());
		System.out.println("nb en places ?"+taquin.nbCasesEnPlace());
		
		// test deplacement impossible
		try {
			taquin.deplacement(DirectionDeplacement.bas);
		} catch (DeplacementImpossibleException e) {
			System.out.println("deplacement vers le bas impossible");
		}		
		taquin.affiche();
		
		// melanger
		taquin.melanger();
		taquin.affiche();
		System.out.println("bien range ?"+taquin.estMotifParticulier());
		System.out.println("nb en places ?"+taquin.nbCasesEnPlace());
		
		// successeurs
		List<Taquin> listSuccesseurs = taquin.successeurs();
		for(Taquin t : listSuccesseurs) {
			t.affiche();
		}
		
	}

}
