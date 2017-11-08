/**
 * First book version for first object manipulations
 * 
 * @author jc
 * @version 1.0
 */

public class Book {

    /** returns <code>true</code> iff this book is equivalent to <code>o</code>, ie. if <code>o</code> is a book
     * and they have the same author, title and publication year
     * @return <code>true</code> iff this book is equivalent to <code>o</code>
     */
    public boolean equals(Object o) {

        if (o instanceof Book) {
            Book l = (Book) o;
            return (this.publicationYear == l.publicationYear) && this.author.equals(l.author)
                    && this.title.equals(l.title);

        } else {
            return false;
        }

    }

    /**
     * book is defined by its author (as a String), its title, its
     * publication year and full text
     * 
     * @param author the author of this book
     * @param title the title of this book
     * @param year the publicatiojn year of this book
     * @param text the text of this book
     */
    public Book(String author, String title, int year, String text) {
        this.author = author;
        this.title = title;
        this.publicationYear = year;
        this.text = text;
    }

    // les attributs de la classe Book
    private String author;
    private String title;
    private int publicationYear;
    private String text;

    // les methodes de la classe     Book

    /**
     * returns this book's author
     * 
     * @return this book's author
     */
    public String getAuthor() { 
        return this.author; 
    }
// ici pas de modificateur setAuthor,  a priori quand un livre est cree il ne change pas d'auteur...
    /**
     * returns this book's title
     * 
     * @return this book's title
     */
    public String getTitle() {
        return this.title; // idem pour title;
    }

    /**
     * display information on this book
     */
    public void display() {
        System.out.println(this.title + " by " + this.author + " published in " + this.publicationYear);
    }

    /**
     * reads this book (actually displays text)
     */
    public void read() {
        System.out.println(this.text);
    }

}
