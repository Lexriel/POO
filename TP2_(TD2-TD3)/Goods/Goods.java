/**
 * The class Goods can model goods.
 * 
 * @author Alexandre Temperville 
 * @version 21/01/2016
 */
public class Goods{
    /** Attributes of Goods
     * @param value price HT in euros
     * @param name name of the goods
     */
    private double value;
    private String name;
    
    /**
     * Constructor for objects of class Goods
     * @param name the name of a goods
     */
    public Goods(String name){
        this.name = name;
        this.value = 0;
    }

    /**
     * Constructor for objects of class Goods
     * @param name the name of a goods
     * @param value the price of a goods
     */
    public Goods(String name, double value){
        this.name = name;
        this.value = value;
    }

    /**
     * Get the value of the goods (accessor)
     * @param 
     * @return the value of the goods 
     */
    public double getValue(){
        return this.value;
    }
    
    /**
     * Set the value of the goods (mutator)
     * @param value
     * @return the value of the goods 
     */
    public void setValue(double value){
        this.value = value;
    }

    /**
     * Get the name of the goods (accessor)
     * @param 
     * @return this name of the goods 
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Set the name of the goods (mutator)
     * @param name
     * @return the name of the goods 
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Give a sentence describing the state of the goods
     * @param 
     * @return str a String
     */
    public String toString(){
        String str = "the goods " + this.name + " costs " + this.value + " euros";
        return str;
    }
    
    /**
     * Computes the TTC value of the goods with a TVA at 19.6%
     * @param 
     * @return ttc_value TTC value of good
     */
    public double ttc(){
        double ttc_value =this.value + this.value*19.6/100;
        return ttc_value;
    }
}
