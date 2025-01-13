package kr.book;

import kr.book.Controller.BookController;
import kr.book.Controller.RentalController;
import kr.book.Controller.UserController;

import java.io.Console;
import java.time.LocalDate;
import java.util.Scanner;

public class LibraryMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConsoleView view = new ConsoleView();
        UserController userController = new UserController();
        RentalController rentalController = new RentalController();
        BookController bookController = new BookController();

        while(true){
             view.printMenu();
             int choice = scanner.nextInt();
             scanner.nextLine();


             switch(choice){

                 case 1:
                     String userId = view.getUserID();
                     String userName = view.getUserName();
                     if(userController.addUser(userId,userName)!= null){

                         System.out.println(userName + " 님, 새로운 회원이 되신것을 환영합니다");
                     } else System.out.println(userName + "님께서는 이미 회원등록을 마친 상태입니다.");
                     break;
                 case 2:
                     String title = view.getTitle();
                     String author = view.getAuthor();
                     String isbn = view.getIsbn();
                     if(bookController.findBookByTitle(title)!= null){
                         System.out.println("새 책이 등록되었습니다! ");

                     }else System.out.println("이미 등록된 책입니다.");
                     break;
                 case 3:
                     userId = view.getUserID();
                     isbn = view.getIsbn();
                     LocalDate rentDay = LocalDate.now();
                     rentalController.addRentalRecord(userId,isbn,rentDay);








             }
        }

    }



}
