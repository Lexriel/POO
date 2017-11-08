package lookup;

public class LookupMain{

    public static void main(String[] args){
	A ref;

	ref = new B();

	System.out.println("--- appel leon 1 ---");
	ref.leon();
		
	ref = new C();
	System.out.println("--- appel leon 2 ---");
	ref.leon();
		
	System.out.println("--- appel timo ---");
	((A) ref).timo();	
    }
}
