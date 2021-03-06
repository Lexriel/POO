package hc;

/**
 * @author <a href="mailto:jean-christophe.routier@univ-lille1.fr">routier </a>
 */
public class Test{

    public static void main(String[] args){
	Enseignant[] ens = new Enseignant[6];
	ens[0] = new EnseignantExterieur("exterieur", 60);
	ens[1] = new EnseignantFac("fac sans HC", 192);
	ens[2] = new EnseignantFac("fac avec HC", 225);
	ens[3] = new EtudiantTroisiemeCycle("etudiant non employe non majore", 60);
	ens[4] = new EtudiantTroisiemeCycle("etudiant non employe majore", 100);
	ens[5] = new EtudiantTroisiemeCycle("etudiant employe non majore", 60);
	for (int i = 0; i < ens.length; i++)
	    System.out.println(ens[i].getNom()+" : "+ens[i].heuresComplementaires()+" hc => "+ens[i].retribution()+" euros");
    }
}
