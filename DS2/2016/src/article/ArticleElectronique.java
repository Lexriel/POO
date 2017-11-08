package article;

public abstract class ArticleElectronique extends AbstractArticle {

	private static final float TAUX_TVA = 19.6f;
	
	protected int garantie;
	
	public ArticleElectronique(float prixHt, String nom, int poids, int garantie) {
		super(prixHt, nom, poids);
		this.garantie = garantie;
	}

	public int getGarantie() {
		return garantie;
	}

	public void setGarantie(int garantie) {
		this.garantie = garantie;
	}


	public float getTVA() {
		return TAUX_TVA;
	}

}
