package article;

public class Vetement extends AbstractArticle {

	private static final float FRAIS_EXPEDITION = 3;
	private static final float TAUX_TVA = 19.6f;

	public Vetement(float prixHt, String nom, int poids) {
		super(prixHt, nom, poids);
		// TODO Auto-generated constructor stub
	}


	public float fraisExpedition() {
		return FRAIS_EXPEDITION;
	}

	@Override
	public float getTVA() {
		return TAUX_TVA;
	}


}
