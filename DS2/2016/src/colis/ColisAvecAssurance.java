package colis;

public class ColisAvecAssurance extends Colis{

    private static final float LIMITE = 100;
    private static final float COUT_BAS = 5;
    private static final float POURCENTAGE = 5;

    private float montantAssure;

    public ColisAvecAssurance(Adresse adresse, float montantAssure){
	super(adresse);
	this.montantAssure = montantAssure;
    }

    public float getMontantAssure(){
	return this.montantAssure;
    }

    public float getFraisExpedition(){
	float fraisBase = super.getFraisExpedition();
	if (this.montantAssure < LIMITE){
	    return fraisBase + COUT_BAS;
	} else{
	    return fraisBase + this.montantAssure*POURCENTAGE/100;
	}

    }

}
