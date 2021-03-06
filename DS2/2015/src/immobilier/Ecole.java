package immobilier;

public class Ecole extends BatimentProfessionnel{
       
    private NiveauScolaire niveau;
    private int nbClasses;

    public Ecole(Adresse adresse, int surface, NiveauScolaire niveau, int nbClasse){
        super(adresse, surface);
        this.niveau = niveau;
        this.nbClasses = nbClasse;       
    }

    public NiveauScolaire getNiveau(){
        return niveau;
    }

    public int getNbClasses(){
        return nbClasses;
    }
    
    public float getSurfaceImposable(){        
        return 0;
    }
}
