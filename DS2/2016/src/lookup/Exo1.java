package lookup;

import java.util.ArrayList;
import java.util.List;

public class Exo1 {

    public static void main(String[] args) {
        List<A> listeA = new ArrayList<A>();
        
        listeA.add(new A());
        listeA.add(new B());
        listeA.add(new C());
        
        for(A a : listeA) {
            System.out.println("--- appel de h()---");
            a.h();
            System.out.println("--- appel de f()---");
            a.f();
        }
    
    }

    
}

class A {
    private void z() {
        System.out.println("A.z");
        this.k();
    }
    public void f() {
        System.out.println("A.f");
        this.z();
        this.g();
    }
    public void g() {
        System.out.println("A.g");
    }
    public void h() {
        System.out.println("A.h");
        this.k();
    }
    public void k() {
        System.out.println("A.k");
    }
    public void m() {
        System.out.println("A.m");
    }
}


class B extends A{
    private void z() {
        System.out.println("B.z");
        this.k();
    }
    public void f() {
        System.out.println("B.f");
        super.f();
        this.g();
    }
    public void k() {
        System.out.println("B.k");
    }
    
}

class C extends B{

    public void g() {
        System.out.println("C.g");
    }
    public void h() {
        System.out.println("C.h");
        this.m();
    }
}