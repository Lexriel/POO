package agence;

/** Interface Criterion using a method depending of the type of the
 * criterion. */
public interface Criterion {
    /** Method isSatisfied.
     * @param c the tested car 
     * @return <code>true</code> iff car c satisfies this criterion
     * @return <code>false</code> else
     */
    public boolean isSatisfiedBy(Car c);
}
