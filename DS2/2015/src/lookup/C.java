package lookup;

public class C extends B{

    public void bar(){
	System.out.println("C.bar");
    }

    public void timo(){
	System.out.println("C.timo");
    }

    @SuppressWarnings("unused")
    private void tresor(){
	System.out.println("B.tresor");
    }
}
