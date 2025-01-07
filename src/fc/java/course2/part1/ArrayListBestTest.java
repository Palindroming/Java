package fc.java.course2.part1;

import fc.java.model2.BookDTO;

import java.util.ArrayList;

public class ArrayListBestTest {

        public static void main(String[] args) {

            //Book 3권을 배열에 저장하고 출력하세요
            //Book, Object[]

            ArrayList<BookDTO> list = new ArrayList<BookDTO>(); //BookDTO 배열만 쓰겠다 선언

            list.add(new BookDTO("자바","한빛","홍길동",20000));
            list.add(new BookDTO("C","대림","이명박",22000));
            list.add(new BookDTO("파이썬", "정보", "윤석열", 22000));

            BookDTO vo = list.get(1);

            System.out.println(vo.toString());
            System.out.println("-----------------------");


            for(int i = 0; i<list.size(); i++){
                System.out.println(list.get(i)); //DownCasting이 필요하다
            }
        }


}
