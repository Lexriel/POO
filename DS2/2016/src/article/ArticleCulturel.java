package article;

public class ArticleCulturel extends AbstractArticle {

	private static final float FRAIS_EXPEDITION = 0;
	private static final float TAUX_TVA = 5.5f;

	public ArticleCulturel(float prixHt, String nom, int poids) {
		super(prixHt, nom, poids);		
	}


	public float fraisExpedition() {
		return FRAIS_EXPEDITION;
	}

	public float getTVA() {
		return TAUX_TVA;
	}

}
