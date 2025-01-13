package kr.book;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleView {

    private Scanner scanner = new Scanner(System.in);

    public String getUserID(){
        System.out.println("사용자 ID를 입력하세요: ");
        return scanner.nextLine();
    }

    public String getUserName(){
        System.out.println("사용자 이름을 입력하세요: ");
        return scanner.nextLine();
    }

    public String getIsbn(){
        System.out.println("책의 ISBN기호를 입력하세요: ");
        return scanner.nextLine();
    }

    public void RentDay(LocalDate date){
        System.out.println("대출일자는 "+ date+ "입니다.");

    }

    public String getTitle(){
        System.out.println("책 이름을 입력하세요: ");
        return scanner.nextLine();
    }

    public String getAuthor(){
        System.out.println("작가 이름을 입력하세요: ");
        return scanner.nextLine();
    }

    public LocalDate getReturnDay(){

        System.out.println("반납일자를 입력하세요: ");
        return LocalDate.parse(scanner.nextLine());
    }








    public void printMenu(){
        System.out.println("===도서관리 시스템===");
        System.out.println("1. 사용자 등록");
        System.out.println("2. 책 등록 ");
        System.out.println("3. 책 대여 ");
        System.out.println("4. 대여 기록 조회");
        System.out.println("5. 책 반납 ");
        System.out.println("6. 종료 ");




    }
}
