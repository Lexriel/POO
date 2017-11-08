import java.lang.Math;

public class Droite{

    // Attributs de la classe Droite
    private Point point1;
    private Point point2;

    // Constructeurs de la classe Droite
    /**
     * Une droite est définie par deux points distincts.
     * @param point p1
     * @param point p2 différent de p1
     */
    public Droite(Point M1, Point M2){
	if (!M1.equals(M2)){
	    this.point1 = M1;
	    this.point2 = M2;
	}
	else
	    System.out.println("Erreur: une droite doit être définie par deux points distincts !");
    }


    // Méthodes de la classe Droite
    public Point getPoint1(){
	return this.point1;
    }

    public Point getPoint2(){
	return this.point2;
    }

    public double[] cartesianCoefficients(){
	double[] triplet = new double[3];
	triplet[0] = this.point2.getY() - this.point2.getX(); // a = y2-x2
	triplet[1] = - (this.point1.getY() - this.point1.getX()); // b = -(y1-x1)
	triplet[2] = - (triplet[0]*this.point1.getX() + triplet[1]*this.point1.getY()); // c=-(ax1+by1)
	return triplet;
    }

    public String toString(){
	    double [] triplet = this.cartesianCoefficients();
	String a = String.valueOf(triplet[0]);
	String b = String.valueOf(triplet[1]);
	String c = String.valueOf(triplet[2]);
        return a + "x + " + b + "y + " + c + " = 0";
    }

    public void lineEquation(){
        System.out.println(this.toString());
    }

    public double distancePointDroite(Point M){
	double [] triplet = this.cartesianCoefficients();
	double a = triplet[0];
	double b = triplet[1];
	double c = triplet[2];
	double d = Math.abs(a*M.getX()+b*M.getY()+c) / Math.sqrt(a*a + b*b);
	return d;
    }

    // public boolean isOnLine(Point M);
    // public boolean areParallel(Droite D);
    // public boolean arePerpendicular(Droite D);
    // public Droite getParallel(Point P);
    // public Droite getPerpendicular(Point P);
    // public static Point intersection(Droite D1, Droite D2);

    public static void main(String[] args){
	
	Point M1 = new Point(1, 2);
	Point M2 = new Point(2, -1);
	Point M3 = new Point(3, 0);
	Droite D = new Droite(M1,M2);
	
	D.lineEquation();
	System.out.println(D.distancePointDroite(M3));
    }    
}
