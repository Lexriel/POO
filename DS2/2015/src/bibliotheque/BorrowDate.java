package bibliotheque;

public class BorrowDate{
    private static int NB_DAYS = 365;
	
    private int year;
    private int dayNum;
	
    public BorrowDate(int annee, int numJour){
	this.year = annee;
	this.dayNum = numJour;
    }

    /**
     * @return the year
     */
    public int getAnnee(){
	return this.year;
    }

    /**
     * @return the number of the day in the year
     */
    public int getNumJour(){
	return this.dayNum;
    }

    /** number of days between this and otherDate, always positive
     * @param otherDate the other BorrowDate from which difference is computed
     * @return number of days between this and "autreDate", always positive
     */
    public int differenceInDays(BorrowDate otherDate){
	if (this.year == otherDate.year){
	    // same year ? result is difference between number of days
	    return Math.abs(this.dayNum - otherDate.dayNum);
	} else{
	    // different years
	    if (this.year < otherDate.year){
		// number of days between this and end of year 
		int result = BorrowDate.nbOfDays(this.year) - this.dayNum;
		// adds days for each complete year between this and otherDate
		for(int a = this.year+1; a < otherDate.year; a++){
		    result = result + BorrowDate.nbOfDays(a);  
		}
		// adds days from beginning of year of otherDate
		return result + otherDate.dayNum;
	    }
	    else{
		// just reverse role between this and "autreDate" to apply above "if then" case
		return otherDate.differenceInDays(this);
	    }
	}
    }
	
    /** <code>true</code> iff <em>year</em> is bissextile, ie. divisible by 4 but not by 100 except if by 400
     * @param year the tested year
     * @return <code>true</code> iff <em>year</em> is bissextile
     */
    public static boolean isBissextile(int year){
	return (year%4==0) && ((year%100 != 0) || (year%400 == 0));
    }
    /** returns the total number of days for the given year
     * @param year the year
     * @return the total number of days for the given year
     */
    public static int nbOfDays(int year){
	if (BorrowDate.isBissextile(year))
	    return NB_DAYS +1;
	else
	    return NB_DAYS;
    }

    /**
     * @return the current Date when invoked, ie. "today"
     */
    public static BorrowDate today(){
	// returns today
	return null;
    }	
}
