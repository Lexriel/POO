
// import java.lang.Math;

public class Complexe{

    // Attributs de la classe Complexe
    /**
     * Attributs de la Classe Complexe : partie réelle, partie imaginaire
     */
    private double re = 0;
    private double im = 0;

    // Constructeurs de la classe Complexe
    /**
     * Un complexe est défini par sa partie réelle et sa partie imaginaire.
     * @param re partie réelle
     * @param im partie imaginaire
     */
    public Complexe(double re, double im){
	this.re = re;
	this.im = im;
    }
    public Complexe(){
    }

    // Méthodes de la classe Complexe
    /**
     * Un complexe est réel si sa partie imaginaire est nulle
     * @param 
     * @return true or false
     */
    public boolean estReel(){
	return (this.im == 0);
    }

    /**
     * Un complexe est imaginaire pur si sa partie réelle est nulle
     * @param 
     * @return true or false
     */
    public boolean estImaginairePur(){
	return (this.re == 0);
    }

    /**
     * Récupère la partie réelle d'un complexe
     * @param 
     * @return partie réelle re du complexe
     */
    public double partieReelle(){
	return this.re;
    }

    /**
     * Récupère la partie imaginaire d'un complexe
     * @param 
     * @return partie imaginaire im du complexe
     */
    public double partieImaginaire(){
	return this.im;
    }

    /**
     * Calcule le module d'un complexe
     * @param 
     * @return res module du complexe
     */
    public double module(){
	double res = Math.pow(this.re, 2) + Math.pow(this.im, 2);
	res = Math.sqrt(res);
	return res;
    }

    // On ne met pas static car conjugue agit sur une instance 
    /**
     * Calcule le conjugué d'un complexe
     * @param 
     * @return z conjugué du complexe
     */
    public Complexe conjugue(){
	Complexe z = new Complexe(this.re, -this.im);
	return z;
    }

    // On met static quand la méthode n'agit pas sur une instance 
    /**
     * Calcule la somme de deux complexes
     * @param z second terme de la somme
     * @return res somme des deux complexes
     */
    public Complexe add(Complexe z){
	Complexe res = new Complexe();
	res.re = this.re + z.re;
	res.im = this.im + z.im;
	return res;
    }

    /**
     * Calcule le produit de deux complexes
     * @param z second facteur du produit
     * @return res produit des deux complexes
     */
    public Complexe mult(Complexe z){
	Complexe res = new Complexe();
	res.re = this.re*z.re - this.im*z.im;
	res.im = this.im*z.re + this.re*z.im;
	return res;
    }

    /**
     * Chaine de caractères représentant un complexe
     * @param 
     * @return chaine de caractères
     */
    public String toString(){
	if (this.im>0)
	    return this.re + " + " + this.im + "i";
	else if (this.im<0)
	    return this.re + " - " + -this.im + "i";
	else
	    return "" + re;
    }

    /**
     * Affiche un complexe
     * @param 
     * @return 
     */
    public void display() {
        System.out.println(this.toString());
    }

    /**
     * Détermine si deux complexes sont égaux
     * @param z complexe à comparer
     * @return true or false
     */
    public boolean equals(Complexe z){
	if (this.re != z.re)
	    return false;
	if (this.im != z.im)
	    return false;
	return true;
    }

    public static void main(String[] args){
	Complexe z1 = new Complexe(1, 2);
	Complexe z2 = new Complexe(2, -1);
	Complexe z3 = new Complexe(3, 0);
	Complexe z4 = new Complexe(0, -2);
	System.out.print("z1 = ");
	z1.display();
	System.out.print("z2 = ");
	z2.display();
	Complexe z5 = z1.add(z2);
	System.out.print("z2 = ");
	z2.display();
	System.out.print("z5 = ");
	z5.display();
	Complexe z6 = z1.mult(z2);
	Complexe z7 = z1.conjugue();
	double m = z1.module();
	System.out.print("z1 ");
	z1.display();
	z2.display();
	z3.display();
	z5.display();
	z6.display();
	System.out.println(m);
	z7.display();
	System.out.println(z1.equals(z2));
	System.out.println(z1.equals(z1));
    }    
}
