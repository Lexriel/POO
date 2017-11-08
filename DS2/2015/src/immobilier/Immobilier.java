package immobilier;

public class Immobilier{
    
    protected Adresse adresse;
    protected int surfaceTotale;

    public Immobilier(Adresse adresse, int surface){
        this.adresse = adresse;
        this.surfaceTotale = surface;
    }

    public float getSurfaceImposable (){
        return this.surfaceTotale;        
    }
   
    public Adresse getAdresse(){
        return adresse;
    }

    public int getSurfaceTotale(){
        return surfaceTotale;
    }
}
