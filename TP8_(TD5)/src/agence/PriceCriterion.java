package agence;

/** A PriceCriterion represent a criterion for a price. */
public class PriceCriterion implements Criterion {
    private int price;
    /** Constructor of a PriceCriterion
	@param price the reference price */
    public PriceCriterion(int price) {
        this.price = price;
    }
    /** Method isSatisfiedBy
	@see Criterion#isSatisfiedBy(Car) */
    public boolean isSatisfiedBy(Car c) {
        return this.price > c.getPrice();
    }
}
