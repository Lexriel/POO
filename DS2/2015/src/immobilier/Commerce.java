package immobilier;

public class Commerce extends BatimentProfessionnel{

    protected int surfaceEntrepot;
    
    public Commerce(Adresse adresse, int surface, int surfaceEntrepot){
        super(adresse, surface);
        this.surfaceEntrepot = surfaceEntrepot;
    }
    
    public float getSurfaceImposable(){
        return this.surfaceTotale - this.surfaceEntrepot;
    }
    
    public int getSurfaceEntrepot(){
        return surfaceEntrepot;
    }
}
