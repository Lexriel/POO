package agence;

/** Class of a car */
public class Car {

    private String brand;
    private String model;
    private int year;
    private int price;

    /** Constructor of a car
     * @param brand
     * @param model
     * @param year
     * @param price
     */
    public Car(String brand, String model, int year, int price) {
	this.brand = brand;
	this.model = model;
	this.year = year;
	this.price = price;
    }

    /** Get the brand
     * @return brand
     */
    public String getBrand() {
	return this.brand;
    }

    /** Get the model
     * @return model
     */
    public String getModel() {
	return this.model;
    }

    /** Get the year
     * @return year
     */
    public int getYear() {
	return this.year;
    }

    /** Get the price
     * @return price
     */
    public int getPrice() {
	return this.price;
    }

    /** Method equals
     * @return true if objects are equal, false else
     */
    public boolean equals(Object o) {
	if (o instanceof Car) {
	    Car theOther = ((Car) o);
	    return this.brand.equals(theOther.brand) && this.model.equals(theOther.model) && this.year == theOther.year
		&& this.price == theOther.price;
	} else {
	    return false;
	}
    }

    /** Method toString
     * @return a String
     */
    public String toString() {
	return this.year + " - " + this.brand + " " + this.model + " "  + this.price + "€";
    }
}
