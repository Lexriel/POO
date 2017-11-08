package article;

public abstract class AbstractArticle {
	protected float prixHT;
	protected String nom;
	protected int poids;
	
	public AbstractArticle(float prixHt, String nom, int poids) {
		this.prixHT = prixHt;
		this.nom = nom;
		this.poids = poids;
	}
	
	public float getPrixHT() {
		return prixHT;
	}
	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}
	public String getNom() {
		return nom;
	}
	public int getPoids() {
		return poids;
	}
	
	public abstract float getTVA();
	public abstract float fraisExpedition();
	
	public float getPrixTTC() {
		return this.prixHT*(1+this.getTVA()/100);
	}
	
	
	// hors-sujet (meme si devrait être systématique) : equals et hashCode
}
