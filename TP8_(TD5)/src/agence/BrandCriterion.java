package agence;

/** A BrandCriterion represent a criterion of a brand. */
public class BrandCriterion implements Criterion {
    private String brand;

    /** Constructor of a BrandCriterion
	@param brand the desired brand */
    public BrandCriterion(String brand) {
        this.brand = brand;
    }
    /** Method isSatisfiedBy
	@see Criterion#isSatisfiedBy(Car) */
    public boolean isSatisfiedBy(Car c) {
        return this.brand.equals(c.getBrand());
    }
}
