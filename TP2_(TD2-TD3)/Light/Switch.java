
/**
 * The class Switch acts on a light bulb and changes its state.
 * 
 * @author Alexandre Temperville
 * @version 21/06/2016
 */
public class Switch{
    // instance variables - replace the example below with your own
    private LightBulb light;

    /**
     * Constructor for objects of class Switch
     */
    public Switch(LightBulb light){
        this.light = light;
    }

    /**
     * Puts a light on
     */
    public void switchStatus(){
        boolean status = this.light.getOn();
        if (status)
          this.light.setOff();
        else
          this.light.setOn();
    }

    /**
     * Return a sentence describing the switch
     */
    public String toString(){
        return "The switch controls the light bulb defined by :\n  " + this.light.toString();
    }

    /**
     * Display a sentence describing the switch
     */
    public void display(){
        System.out.println(this.toString());
    } 

}
