package afficheur;

/**
 * Classe Clock
 */
public class Clock{
    
    private LedDisplayer displayer;
    
    public Clock(LedDisplayer a){
	this.displayer = a;
    }

    public void tryIt(int nbTop){
	String message = "Abcd";
	displayer.setMessage(message);
	for (int i=0; i<nbTop; i++){
	    displayer.shift();
	    System.out.println("|" + displayer.textOnScreen() + "|");
	}
    }

    public static void main(String[] args){
	int n = 5;
	int nbTop = 8;
	Clock t = new Clock(new LedDisplayer(n));
	t.tryIt(nbTop);
	System.out.println("*********************************");
	t = new Clock(new DisplayerWithLatency(n, 3));
	t.tryIt(nbTop);
	System.out.println("*********************************");
	t = new Clock(new SpeedDisplayer(n, 3, 2));
	t.tryIt(nbTop);
    }
}
