package immobilier;

// Q 2

public class Studio extends Appartement{

    private final static float COEFF_REDUC = 0.9f;
    
    public Studio(Adresse adresse, int surface, int nbPieces, int etage){
        super(adresse, surface, 1, etage);
    }
    
    public float getSurfaceImposable(){
        return COEFF_REDUC * super.getSurfaceImposable();
    }
}
