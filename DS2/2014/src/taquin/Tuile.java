package taquin;

// Q1

/**
 * @author  jc
 */
public class Tuile{

    private int numero;
    public static final Tuile TROU = new Tuile(-1);

    public Tuile(int numero){
	this.numero = numero;
    }

    /**
     * @return
     */
    public int getNumero(){
	return this.numero;
    }

    public String toString(){
	return "[" + this.numero+"]";
    }
}
