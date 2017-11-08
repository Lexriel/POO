package immobilier;

public class Appartement extends Habitation{

    protected int etage;

    public Appartement(Adresse adresse,int surface, int nbPieces, int etage){
        super(adresse, surface, nbPieces);
        this.etage = etage;
    }

    public int getEtage(){
        return etage;
    }
}
