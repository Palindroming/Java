package fc.java.course2.part1;

import fc.java.model2.*;
import fc.java.model2.A;

public class MyObjectArrayTest {
    public static void main(String[] args) {

        //A B C 객체를 배열에 저장, 출력하세요.

        ObjectArray list = new ObjectArray();
        list.add(new A());
        list.add(new B());
        list.add(new C());

        A a = (A)list.get(0);
        a.display();


        B b= (B)list.get(1);
        b.display();


        for(int i  = 0; i<list.size(); i++) {
            if (list.get(i) instanceof A) {
                ((A) list.get(i)).display();
            } else if (list.get(i) instanceof B) {
                ((B) list.get(i)).display();
            } else {
                ((C) list.get(i)).display();

            }
        }}}

