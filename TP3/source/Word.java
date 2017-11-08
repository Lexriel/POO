/**
 * Word class : methods on Words (tp3) licence S4 - UE POO
 * 
 * @author : Alexandre Temperville
 */

public class Word{

    // ATTRIBUTS
    /* contains the string that represents the charcter of this word */
    private String value;

    // CONSTRUCTEURS
    public Word(String s){
	this.value = s;
    }

    // METHODES
    /**
     * returns <code>true</code> if <code>o</code> is equals to this word object, ie if
     * <code>o</code> is a Word and its value is the same as this word's value
     * @param o the object to be compared with this Word
     * @return <code>true</code> iff <code>o</code> is a Word with the same value as this word.
     */
    public boolean equals(Object o){
	if (o instanceof Word) {
	    Word theOther = (Word) o;
	    return this.value.equals(theOther.value);
	} else {
	    return false;
	}
    }

    /**
     * Returns the number of characters of the String <code>value</code>
     * @return number of characters of <code>value</code>
     */
    public int nbOfChars(){
	return this.value.length();
    }

    /**
     * Returns the String <code>value</code>
     * @return the String <code>value</code>
     */
    public String toString(){
	return this.value;
    }

    /**
     * Returns the number of occurrences of a character <code>c</code>
     * in the String <code>value</code>
     * @param c a character
     * @return the number of occurrences of <code>c</code>
     */
    public int nbOccurrencesOfChar(char c){
	int res = 0;
	for(int i=0; i<this.nbOfChars(); i++)
	    if (c == this.value.charAt(i))
		res++;
	return res;
    }

    /**
     * Returns the reverse of a word
     * @return the reverse of a word
     */
    public Word reverse(){
	String s = "";
	for (int i = this.nbOfChars()-1; i>=0; i--)
	    s += this.value.charAt(i);
	return new Word(s);
    }

    /**
     * Returns true if the word is a palindrom, false else
     * @return true if the word is a palindrom, false else
     */
    public boolean isPalindrome(){
	return this.equals(this.reverse());
    }

    /**
     * Returns true if <code>this</code> contains the word <code>m</code>
     * @param m a Word
     * @return true if <code>this</code> contains the word <code>m</code>
     */
    public boolean contains(Word m){
	// /*Cette seule instruction suffit */
	// return this.value.indexOf(m.value) != -1;
	int n = m.nbOfChars();
	for (int i=0; n+i <= this.nbOfChars(); i++){
	    String s = new String(this.value.substring(i, n+i));
	    if (s.equals(m.value))
		return true;
	}
	return false;
    }

    /**
     * Returns true if the two words rhym together
     * @param m a Word
     * @return true if <code>m</code> rhyms with <code>this</code>
     */
    public boolean rhymesWith(Word m){
	int mLength = m.nbOfChars();
	int thisLength = this.nbOfChars();
	if (thisLength<3 || mLength<3)
	    return false;
	String mRhym = m.value.substring(mLength-3,mLength-1);
	String thisRhym = this.value.substring(thisLength-3,thisLength-1);
	return mRhym.equals(thisRhym);
    }

    /**
     * Returns true if the word is proper, false else
     * @return true if the word is proper, false else
     */
    public boolean isProperNoun(){
	return Character.isUpperCase(this.value.charAt(0));
    }

    /**
     * Returns true if the word <code>m</code> is an anagram of <code>this</code>, false else
     * @param m a Word
     * @return true if the word <code>m</code> is an anagram of <code>this</code>, false else
     */
    public boolean isAnagram(Word m){
	for(int i=0; i<this.nbOfChars(); i++){
	    char c = this.value.charAt(i);
	    if (m.nbOccurrencesOfChar(c) != this.nbOccurrencesOfChar(c))
		return false;
	}	
	return true;
    }

    /**
     * Returns an array which cut a word in two parts
     * @param c a character
     * @return an array of two words, the first is the word until the first occurrence of <code>c</code>, the second the rest of the word. If the character is not in the word, the first word is ""
     */
    public Word[] extractBefore(char c){
    	Word[] wordTab = new Word[2];
    	int n = this.value.indexOf(c);
    	wordTab[0] = new Word(this.value.substring(0,n+1));
    	wordTab[1] = new Word(this.value.substring(n+1,this.nbOfChars()));
    	return wordTab;
    }

    public static void main(String[] args){
	if (args.length == 0)
	    return;
	Word W = new Word(args[0]);
	System.out.println("Word: " + W.toString());
	System.out.println("* nbOfChars: " + W.nbOfChars());
	System.out.println("* nbOccurrencesOfChars: " + W.nbOccurrencesOfChar('a'));
	System.out.println("* reverse: " + W.reverse());
	Word W2 = new Word("ou");
	W.contains(W2);
	System.out.println("* contains: " + W.contains(W2));
	System.out.println("* contains: " + W.isPalindrome());
	// int n = W.value.indexOf('a');
	// System.out.println("n = " + n);
	Word[] wordTab = new Word[2];
	wordTab = W.extractBefore('a');
	System.out.println("* extractBefore: [" + wordTab[0] + "," + wordTab[1] + "]");
	System.out.println("* isAnagram de \"rame\": " + W.isAnagram(new Word("rame")));
    }
}
