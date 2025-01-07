package fc.java.model2;
//BB는 노출 시키지 않는다.(BB.class => 0 ) (BB.java => x)
public class BB implements CC{


    @Override
    public void x() {
         System.out.println("x");
    }

    @Override
    public void y() {
        System.out.println("y");
    }

    @Override
    public void z() {
        System.out.println("z");
    }
}
