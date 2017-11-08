package article;

public class AppareilElectronique extends ArticleElectronique {

	private static final float POURCENTAGE = 10;
	private static final int FIXE = 2;

	public AppareilElectronique(float prixHt, String nom, int poids, int garantie) {
		super(prixHt, nom, poids, garantie);
	}

	public float fraisExpedition() {
		return FIXE+(this.poids*POURCENTAGE/100);
	}

}
