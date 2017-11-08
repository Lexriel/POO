package immobilier;

public class Habitation extends Immobilier{
    
    protected int nbPieces;
 
    public Habitation(Adresse adresse, int surface, int nbPieces){
        super(adresse, surface);
        this.nbPieces = nbPieces;
    }
}
