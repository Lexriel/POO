package agence;

/** Class InterCriterion defines a criterion made by two existing
    criteria */
public class InterCriterion implements Criterion {
    
    private Criterion criterion1;
    private Criterion criterion2;

    /** Constructor who builds a criterion made by two existing
	criteria
	@param c1 first criterion
	@param c2 second criterion */
    public InterCriterion(Criterion c1, Criterion c2) {
        this.criterion1 = c1;
        this.criterion2 = c2;
    }

    /** Method isSatisfiedBy
	@see Criterion#isSatisfiedBy(Car) */
    public boolean isSatisfiedBy(Car c) {
    	return this.criterion1.isSatisfiedBy(c) && this.criterion2.isSatisfiedBy(c);
    }
}
