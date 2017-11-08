package agence;

import java.util.ArrayList;
import java.util.List;

/** Class of a rental agency, proposing to rent cars. */
public class RentalAgency {
    private List<Car> cars;

    /** Constructor of a RentalAgency */
    public RentalAgency() {
	this.cars = new ArrayList<Car>();
    }

    /** Get all the cars */
    public List<Car> getAllCars() {
	return this.cars;
    }

    /** Remove a car <code>c</code> of the RentalAgency if it exists
     * @param c car to remove
     * @exception UnknownCarException if <code>c</code> is not in the
     * RentalAgency
     */
    public void remove(Car c) throws UnknownCarException{
	// boolean isFound = this.getAllCars().remove(c);
	boolean isFound = this.cars.remove(c);
	if (! isFound)
	    throw new UnknownCarException();
    }

    /** Add a car <code>c</code> to the RentalAgency
     * @param c car to add
     */
    public void add(Car c){
	// boolean isFound = this.getAllCars().add(c);
	boolean isFound = this.cars.add(c);
    }

    /** Select cars satisfying a criterion <code>crit</code>
     * @param crit the criterion to satisfy
     * @return a list of cars
     */
    public List<Car> select(Criterion crit) {
	List<Car> result = new ArrayList<Car>();
	// for (Car car: this.getAllCars()) {
	for (Car car: this.cars) {
	    if (crit.isSatisfiedBy(car)) {
		result.add(car);
	    }
	}
	return result;
    }

    /** Return a String describing the rental agency
     * @return a String describing the RentalAgency
     */
    public String toString(){
	String s = new String("RentalAgency:\n");
	for (Car car: this.cars){
	    s += "  " + car.toString() + "\n";
	}
	return s;
    }
    
    /** Main method of the package agence
     * @param args arguments (not used)
     */
    public static void main(String[] args){
	RentalAgency R = new RentalAgency();
	Car c1 = new Car("Peugeot", "806", 2013, 65);
	Car c2 = new Car("Ford", "Focus", 2015, 115);
	Car c3 = new Car("Peugeot", "206", 2014, 30);
	Car c4 = new Car("Toyota", "Prius", 2015, 75);
	Car c5 = new Car("Renault", "Clio 3", 2014, 42);
	Car c6 = new Car("Peugeot", "3008", 2016, 120);
	Car c7 = new Car("Renault", "Kangoo", 2013, 35);
	System.out.println(c1.getBrand());
	System.out.println(c1.toString());
	R.add(c1);
	R.add(c2);
	R.add(c3);
	R.add(c4);
	R.add(c5);
	R.add(c6);
	R.add(c7);
	System.out.println(R);
	// R.remove(c2); ne fonctionne pas car le compilateur s'attend
	// à une gestion de l'exception, comme suit :
	for (int i=0; i<2; i++){
	    try{
		R.remove(c2);
		System.out.println("Removed car: " + c2);
	    }
	    catch(UnknownCarException e){
		System.out.println("UnknownCarException - the wanted car is not proposed for renting :\n" + c2);
	    }
	}

	System.out.println("List of cars under 100€ per day:");
	Criterion crit1 = new PriceCriterion(100);
	List<Car> cheapCars = R.select(crit1);
	System.out.println(cheapCars);
	System.out.println("List of Peugeot cars under 100€ per day:");
	Criterion crit2 = new BrandCriterion("Peugeot");
	InterCriterion crit = new InterCriterion(crit1, crit2);
	List<Car> cheapPeugeot = R.select(crit);
	System.out.println(cheapPeugeot);

    }
}
