import java.lang.Math;

public class Point{

    // Attributs de la classe Point
    private double x = 0;
    private double y = 0;

    // Constructeurs de la classe Point
    /**
     * Un point est défini par ses coordonnées
     * @param abscisse x
     * @param ordonnée y
     */
    public Point(double x, double y){
	this.x = x;
	this.y = y;
    }
    public Point(){
    }

    // Méthodes de la classe Point
    public double getX(){
	return this.x;
    }

    public double getY(){
	return this.y;
    }

    public void setX(double X){
	this.x = X;
    }

    public void setY(double Y){
	this.y = Y;
    }

    public static double longueur(Point M1, Point M2){
	double d = Math.pow(M1.x-M2.x, 2) + Math.pow(M1.y-M2.y, 2);
	d = Math.sqrt(d);
	return d;
    }

    public String toString(){
	String X = String.valueOf(this.x);
	String Y = String.valueOf(this.y);
	return "(" + X + "," + Y + ")";
    }

    public void display() {
        System.out.println(this.toString());
    }

    public boolean equals(Point M){
	if (this.x != M.x)
	    return false;
	if (this.y != M.y)
	    return false;
	return true;
    }

    public static void main(String[] args){

	Point M1 = new Point(1, 2);
	Point M2 = new Point(2, -1);
	Point M3 = new Point(3, 0);
	double d = longueur(M1, M2);

	M1.display();
	M2.display();
	System.out.println(d);
	System.out.println(M3.x);
	System.out.println(M3.getY());
	System.out.println(M1.equals(M2));
	System.out.println(M1.equals(M1));
    }    
}
