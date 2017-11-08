package bibliotheque;

/**
 * @author JC
 *
 */
public class Book{

    private String bookId;
    private String title;
    private int borrowDuration;
	
    /** creates a book with given title and id, the id is assumed to be unique 
     * @param title the title of the book
     * @param bookId the book's id, assumed to be unique
     */
    public Book(String title, String bookId){
	this(title, bookId, Library.DEFAULT_BORROW_DURATION);
    }	
    /** creates a book with given title and id, the id is assumed to be unique 
     * @param title the title of the book
     * @param bookId the book's id, assumed to be unique
     * @param borrowDuration the maximal duration of borrowing for this book
     */
    public Book(String title, String bookId, int borrowDuration){
	this.title = title;		
	this.bookId = bookId;
	this.borrowDuration = borrowDuration;
    }

    /**
     * @return the bookId
     */
    public String getBookId(){
	return bookId;
    }

    /**
     * @return the title
     */
    public String getTitle(){
	return title;
    }
		
    /** the maximal allowed borrow duration for this book
     * @return the maximal allowed borrow duration for this book
     */
    public int getBorrowDuration(){
	return borrowDuration;
    }
    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
	return "Book [bookId=" + bookId + ", title=" + title + "]";
    }

	
    // Q3	
    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode(){
	return ((bookId == null) ? 0 : bookId.hashCode());
    }

    /** two books are equals iff they have same id
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj){
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof Book))
	    return false;
	Book other = (Book) obj;
	if (bookId == null){
	    if (other.bookId != null)
		return false;
	}
	else if (!bookId.equals(other.bookId))
	    return false;
	return true;
    }	
}
