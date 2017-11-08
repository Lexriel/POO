
/**
 * Write a description of class LightBulb here.
 * 
 * @author Alexandre Temperville
 * @version 21/06/2016
 */
public class LightBulb{
    // instance variables
    private boolean on;
    private double power;
    private String color;

    /**
     * Constructor for objects of class LightBulb
     * @param  power   power of the light bulb in watts
     */
    public LightBulb(double power){
        this.on = false;
        this.power = power;
        this.color = "white";
    }
     /**
     * Constructor for objects of class LightBulb
     * @param  power   power of the light bulb in watts
     * @param  color   String 
     */
    public LightBulb(double power, String color){
        this.on = false;
        this.power = power;
        this.color = color;
    }

    /**
     * Gets the value of on
     */
    public boolean getOn(){
        return this.on;
    }
    
    /**
     * Gets the value of power
     */
    public double getPower(){
        return this.power;
    }

    /**
     * Gets the value of color
     */
    public String getColor(){
        return this.color;
    }

    /**
     * Puts a light on
     */
    public void setOn(){
        this.on = true;
    }

    /**
     * Puts a light off
     */
    public void setOff(){
        this.on = false;
    }
    
    /**
     * Return a sentence describing the light bulb
     */
    public String toString(){
        if (this.on ==true)
            return "status = on ; color = " + this.color + " ; power = " + this.power + "W";
        return "status = off ; color = " + this.color + " ; power = " + this.power + "W";
    }

    /**
     * Display a sentence describing the light bulb
     */
    public void display(){
        System.out.println(this.toString());
    }
}
