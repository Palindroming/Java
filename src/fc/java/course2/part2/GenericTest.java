package fc.java.course2.part2;

import fc.java.model2.BookArray;
import fc.java.model2.BookDTO;
import fc.java.model2.ObjectArr;

import java.awt.print.Book;

public class GenericTest {

    public static void main(String[] args) {

//

        ObjectArr<BookDTO> books = new ObjectArr<>(10);
        books.set(0,new BookDTO("어떻게 살 것인가","돌베게","유시민",13000));
        books.set(1,new BookDTO("그의 운명에 관한 아주 개인적인 생각","돌베게","유시민",15622));
        books.set(2,new BookDTO("운명이다","사람사는 세상","노무현",13000));


        for(int i = 0; i < books.size(); i++){
            BookDTO book = books.get(i);
            System.out.println(book);
        }




    }
}
