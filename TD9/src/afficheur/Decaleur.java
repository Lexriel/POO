package afficheur;

/** Classe Decaleur
 */
public class Decaleur{

    private char[] text;

    /** Constructeur d'un Décaleur
     * @param largeur taille du tableau text
     */
    public Decaleur(int largeur){
	this.text = new char[largeur];
	for (int i=0; i<largeur; i++)
	    this.text[i] = ' ';
    }

    /** Décale d'un caractère vers la gauche et ajoute car à la place
     * du dernier caractère
     * @param car caractère
     */
    public void decale(char car){
	for (int i=0; i<this.text.length-1; i++)
	    this.text[i] = this.text[i+1];
	this.text[this.text.length - 1] = car;
    }

    /** Renvoie le tableau de caractères sous la forme d'un String
     * @return chaine de caractères de type String
     */
    public String toString(){
	return new String(this.text);
    }
}
