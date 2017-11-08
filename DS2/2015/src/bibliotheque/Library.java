package bibliotheque;

import java.util.LinkedList;
import java.util.List;

public class Library{

    public static final int DEFAULT_MAX_BORROWS = 3;
    public static final int DEFAULT_BORROW_DURATION = 21;
	
    private List<Book> theBooks;
    private List<Borrower> theBorrowers;
	
    public Library(){
	this.theBooks = new LinkedList<Book>();
	this.theBorrowers = new LinkedList<Borrower>();
    }
	
    // Q8
    /** returns the list of borrowers with at least one borrow exceeding allowed duration
     * @return the list of borrowers with at least one borrow exceeding allowed duration
     */
    public List<Borrower> borrowersOutOfDelay(){
	List<Borrower> result = new LinkedList<Borrower>();
	for (Borrower borrower : this.theBorrowers){
	    if (borrower.isOutOfDelay())
		result.add(borrower);
	}
	return result;
    }

    // Q10
    /** alerts every out of delay borrower using his alert system
     * 
     */
    public void outOfDelayBorrowersAlert(){
	List<Borrower> outOfDelay = this.borrowersOutOfDelay();
	for(Borrower borrower : outOfDelay)
	    borrower.getAlertSystem().sendMessage("you're out of delay");
    }
}
