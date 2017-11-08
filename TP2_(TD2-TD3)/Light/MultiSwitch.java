
/**
 * The class MultiSwitch simultaneously acts on several light bulbs and changes their state.
 * 
 * @author Alexandre Temperville
 * @version 21/06/2016
 */
public class MultiSwitch{
    // instance variables
    private LightBulb[] lights;
    private int maxi;
    
    /**
     * Constructor for objects of class MultiSwitch
     */
    public MultiSwitch(int maxi){
        this.maxi = maxi;
        this.lights = new LightBulb[maxi];
    }

    /**
     * Fix the i-th light bulb controled by the multi-switch. Nothing happens if i do not correspond to a
     * correct index
     * @param i the index of the light bulb controled
     * @param theBulb the light bulb controled
     */
    public void setLightBulb(int i, LightBulb theBulb){
        if (i>=0 && i<maxi)
            this.lights[i] = theBulb;       
    }

    /**
     * Switch states of the lights controled by the object MultiSwitch
     */
    public void multiSwitchStatus(){
        boolean status;
        for (LightBulb light : this.lights){
            if (light == null)
              continue;
            status = light.getOn();
            if (status)
              light.setOff();
            else
              light.setOn();
            }
    }

    /**
     * Return a sentence describing the switch
     */
    public String toString(int i){
        if (this.lights[i] != null)
           return "  * Light n°" + i + ": " + this.lights[i].toString();
        return "  * Light n°" + i +": not affected";
    }

    /**
     * Display a sentence describing the switch
     */
    public void displayBulbStates(){
        System.out.println("This multi-switch controls:");
        for (int i=0; i<this.lights.length; i++){
            System.out.println(this.toString(i));
        }
    } 

}
