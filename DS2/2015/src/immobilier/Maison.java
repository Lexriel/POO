package immobilier;

public class Maison extends Habitation{

    protected int surfTerrain;

    public Maison(Adresse adresse, int surface, int nbPieces, int surfTerrain){
        super(adresse, surface, nbPieces);
        this.surfTerrain = surfTerrain; 
    }

    public int getSurfTerrain(){
        return surfTerrain;
    }
}
