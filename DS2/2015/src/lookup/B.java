package lookup;

public class B extends A{

    public void foo(){
	System.out.println("B.foo");
    }

    public void bar(){
	System.out.println("B.bar");
    }

    public void leon(){
	System.out.println("B.leon");
	this.timo();
	super.leon();
    }

    private void tresor(){
	System.out.println("B.tresor");
    }
}
