package colis;

public class ColisExpress extends Colis {
	private static final float COEFF = 2;


	public ColisExpress(Adresse adresse) {
		super(adresse);
	}

	public float getFraisExpedition() {
		return COEFF*super.getFraisExpedition();
	}

}
