
/**
 * The class Stock can models the stock of products.
 * 
 * @author Alex Temperville
 * @version 21/06/2016
 */
public class Stock{
    // instance variables
    private int quantity;

    /**
     * Constructor for objects of class Stock initialized to 0
     */
    public Stock(){
        // initialise instance variables
        this.quantity = 0;
    }

    /**
     * Constructor for objects of class Stock initialized by a parameter initial_qty
     * @param initial_qty initial quantity of the stock
     */
    public Stock(int initial_qty){
        // initialise instance variables
        this.quantity = initial_qty;
    }

    /**
     * Get the quantity of the stock
     * 
     * @param 
     * @return this quantity
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * Add elements in the existing stock
     * 
     * @param n number of elements to add
     * @return 
     */
    public void add(int n){
        this.quantity += n;
    }

    /**
     * Remove elements in the existing stock
     * 
     * @param qte_removed number of elements to remove
     * @return the effective number of elements removed
     */
    public int remove(int qty_removed){
        
        if (qty_removed <= this.quantity){
            this.quantity -= qty_removed;
            return qty_removed;
        }
        // else
        qty_removed= this.quantity;
        this.quantity = 0;
        return qty_removed;
    }

    /**
     * Remove elements in the existing stock
     * 
     * @param 
     * @return str a string describing the attributes of the stock object
     */
    public String toString(){
        String str = "the stock's quantity is " + this.quantity;
        return str;
    }

    public static void main(String[] args) {
	if (args.length < 1){
	    System.out.println("usage : java Stock <unEntier>");
	    System.exit(0); // arrête l'exécution
	}
	Stock someStock = new Stock();
	// someStock.add(10);
	someStock.add(Integer.parseInt(args[0]));
	System.out.println(someStock.getQuantity());
    }
}
