package fc.java.course2.part1;
import fc.java.model2.BookArray;
import fc.java.model2.BookDTO;

public class MyBookArrayTest {
    public static void main(String[] args) {
        //책 3권의 데이터를 배열에 저장하고 출력하세요?
        BookArray bookArray = new BookArray(); //길이 5

        bookArray.add(new BookDTO("자바","한빛","홍길동",20000));
        bookArray.add(new BookDTO("C","대림","이명박",22000));
        bookArray.add(new BookDTO("파이썬", "정보", "윤석열", 22000));


        BookDTO vo = bookArray.get(0);
        System.out.println(vo);//vo.toString() : BookDTO{title='자바', company='한빛', author='홍길동', price=20000}
        vo = bookArray.get(1);
        System.out.println(vo);//vo.toString() : BookDTO{title='자바', company='한빛', author='홍길동', price=20000}
        vo = bookArray.get(-1);
        System.out.println(vo);//vo.toString() : BookDTO{title='자바', company='한빛', author='홍길동', price=20000}

//        for(int i = 0; i < bookArray.size(); i++){
//            System.out.println(bookArray.get(i));
//        }


    }
}
