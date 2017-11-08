/* Question 1*/
/* On propose un type énuméré. On a dans un fichier HardDriveType.java : */
package computer;
public enum HardDriveType{
    HDD5400, HDD7200, SSD;
}

/* Question 2 */
/* Important : package, accesseurs get..., constructeur, toString, equals */
package computer;

public class DriveConfiguration{
    private HardDriveType hdType; // type énuméré
    private int hdCapacity;
    
    public DriveConfiguration(HardDriveType hdType, int hdCapacity){
	this.hdType = hdType;
	this.hdCapacity = hdCapacity;
    }

    public HardDriveType getHdType(){
	return hdType;
    }
    
    public int getHdCapacity(){
	return hdCapacity;
    }
    
    public String toString(){
	return "drive "+this.hdType+" of "+this.hdCapacity+"Go";
    }
    
    public boolean equals(Object o){ // cf question 5 pour détail du contenu d'equals
	if (this == o)
	    return true;
	if (o == null)
	    return false;
	if(o instanceof DriveConfiguration){
	    DriveConfiguration obj = (DriveConfiguration) o;
	    if (hdCapacity != other.hdCapacity)
		return false;
	    if (hdType != other.hdType)
		return false;
	    return true;
	}
	else
	    return false;
    }
}

/* Question 3 */
/* Important : présence de @Test en majuscule, signature du test,
 * pertinence des tests, usage de assertTrue, assertFalse,
 * assertEquals, assertNotNull... */
@Test
public void testEquals(){
    DriveConfiguration d1 = new DriveConfiguration(SSD, 500);
    DriveConfiguration d2 = new DriveConfiguration(SSD, 500);
    DriveConfiguration d3 = new DriveConfiguration(HDD5400, 1000);
    assertTrue(d1.equals(d2));
    assertFalse(d1.equals(d3));
}

/* Question 4 */
/* Diagramme UML de la classe ComputerConfiguration */
//  _____________________________________________________________________________
// |                                                                             |
// |                      << class >> ComputerConfiguration                      |
// |_____________________________________________________________________________|
// | - driveConfig: DriveConfiguration                                           |
// | - ram: int                                                                  |
// | - cpu: String                                                               |
// |_____________________________________________________________________________| 
// | + ComputerConfiguration(cpu: String, ram: int, config: DriveConfiguration)  |
// | + getRam(): int                                                             |
// | + getCPU(): String                                                          |
// | + getDriveConfig(): DriveConfiguration                                      |
// | + toString(): String                                                        |
// | + equals(o: Object): boolean                                                |
// |_____________________________________________________________________________|


/* Question 5 */
/* La signature d'equals doit exactement être la suivante. Elle prend
   (toujours) en paramètre un objet dont on vérifiera que son type
   effectif est exactement le même que celui de la classe qui
   l'implémente (avec instanceof). Il faut ensuite comparer tous les
   autres champs (à moins que l'un d'eux garantisse l'unicité (comme un
   identifiant style NIP)). Les comparaisons des attributs se font avec
   des equals pour les objets et des == pour les types primitifs (style
   int, float) ou types énumérés. */
public boolean equals(Object o){
    if (this == o)
	return true;
    if (o == null)
	return false;
    if(o instanceof ComputerConfiguration){
	ComputerConfiguration obj = (ComputerConfiguration) o;
	if (this.ram != obj.ram)
	    return false;
	if (!this.cpu.equals(obj.cpu))
	    return false;
	if (!this.driveConfig.equals(obj.driveConfig))
	    return false;
	return true;
    }
    else
	return false;
}

/* Question 6 */
/* Important : le package et l'import des configuration (inutile
 * d'importer ce qu'il y a dans computer car déjà accessible) ! */
package computer;
import computer.option.ConfigOption;
public class ForSaleComputer{
    // ...
}

/* Question 7 */
/* Attribut public car symbole +, static car souligné, final car en
 * majuscules */
public static final int NB_MAX_OPTIONS = 3;

/* Question 8 */
/* Important : création d'un tableau et utilisation de la constante
 * statique */
public ForSaleComputer(ComputerConfiguration initialConfig, float initialPrice){
    this.config = initialConfig;
    this.price = initialPrice;
    this.options = new ConfigOption[ForSaleComputer.NB_MAX_OPTIONS];
}

/* Question 9 */
/* Important : javadoc commence par "/**", @param précède les
 * informations sur les paramètres, @exception est obligatoire dès
 * lors qu'une exception est lancée. Le code devant lancer une
 * exception, la signature de setOption doit contenir "throws
 * InvalidOptionException", et l'exception est lancée dans le code
 * avec le mot clé "throw". */
/**
 * set the i-th option of a ForSaleComputer computer
 * @param option the option to set
 * @param i option number
 * @exception InvalidOptionException if <code>i</code> does not
 * correspond to a valid option number
 */
public void setOption(ConfigOption option, int i) throws InvalidOptionException{
    if (i < 0 || i >= ForSaleComputer.NB_MAX_OPTIONS){
	throw new InvalidOptionException("option number not valid");
    }		
    this.options[i] = option;
}

/* Question 10 */
/* Important : distinguer dans la boucle les cas où option vaut null */
public float getPrice(){
    float result = this.price;
    for(ConfigOption option: this.options){
	if (option != null){
	    result = this.price + option.additionalCost(this.config);
	}
    }
    return result;
}

/* Question 11 */
/* Important : cette classe implémente ConfigOption, son seul attribut
 * est son surcout, il est fixe (final) (on peut le rendre static),
 * cette classe doit au minimum contenir les méthodes de
 * ConfigOption. Attention au package et à l'import. */
package computer.option;
import computer.ComputerConfiguration;

public class ScreenOption implements ConfigOption{

    private static final float SCREEN_PRICE = 150f; 
    
    // mot clé précisant que la méthode hérite de ou implémente une autre classe
    @Override 
    public ComputerConfiguration apply(ComputerConfiguration initialConfig){		
	return initialConfig;
    }
    
    @Override
    public float additionalCost(ComputerConfiguration initialConfig){
	return ScreenOption.SCREEN_PRICE;
    }
    
    @Override
    public String description(){
	return "add a Screen";
    }
}

/* Question 12 */
/* Important : cette classe implémente ConfigOption, un attribut COEFF
 * fixe et indépendant de la classe (static final) est utilisé, un
 * attribut pour une nouvelle capacité est utilisé, cette classe doit
 * au minimum contenir les méthodes de ConfigOption. Attention au
 * package et à l'import. */
package computer.option;
import computer.ComputerConfiguration;
import computer.DriveConfiguration;

public class CapacityDriveOption implements ConfigOption{

    private static final float COEFF = 0.2f;
    private int newCapacity;
	
    public CapacityDriveOption(int newCapacity){
	this.newCapacity = newCapacity;
    }

    @Override
    public ComputerConfiguration apply(ComputerConfiguration initialConfig){
	DriveConfiguration newDrive = new DriveConfiguration(initialConfig.getDriveConfig().getHdType(), this.newCapacity);
	return new ComputerConfiguration(initialConfig.getCPU(), initialConfig.getRam(), newDrive);
    }

    @Override
    public float additionalCost(ComputerConfiguration initialConfig){
	int initialCapacity = initialConfig.getDriveConfig().getHdCapacity();
	return (this.newCapacity - initialCapacity) * COEFF;
    }

    @Override
    public String description(){
	return "change drive capacity to " + this.newCapacity;
    }

}

/* Question 13 */
/* Important : usage de try/catch pour les méthodes lançant des exceptions */
public static void main(String[] args){
    DriveConfiguration driveConfig = new DriveConfiguration(HardDriveType.HDD7200, 500);
    ComputerConfiguration computerConfig = new ComputerConfiguration("proc2GHz", 8, driveConfig);
    ForSaleComputer computer = new ForSaleComputer(computerConfig, 500);
    try{
	computer.setOption(new ScreenOption(), 1);
	computer.setOption(new CapacityDriveOption(1000), 2);
    } catch(InvalidOptionException e){
	// will not occur
    }
    System.out.println(computer.getPrice());

    try{
	computer.setOption(new ScreenOption(), 4);
    } catch(InvalidOptionException e){
	System.out.println("exception : ajout impossible");
    }
}
