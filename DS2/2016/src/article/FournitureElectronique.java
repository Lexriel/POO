package article;

public class FournitureElectronique extends ArticleElectronique {

	private static final float FRAIS_EXPEDITION = 0;

	public FournitureElectronique(float prixHt, String nom, int poids, int garantie) {
		super(prixHt, nom, poids, garantie);		
	}

	@Override
	public float fraisExpedition() {		
		return FRAIS_EXPEDITION;
	}

}
