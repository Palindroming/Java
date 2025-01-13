package bookSearch;

import java.util.List;
import java.util.Scanner;

public class BookSearchMain {

   public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("도서제목을 입력하세요: ");
            String bookTitle = scanner.nextLine();
            List<Book> books = KakKaoBookAPI.searchBooks(bookTitle);

            if (books.isEmpty()) {
                System.out.println("검색 결과가 없습니다. ");


            } else {
                for(Book book: books){
                    System.out.println(book.toString());
                }

                String filename = "도서목록.pdf";
                PdfGenerator.generateBookListPdf(books,filename);
                System.out.println("출력이 완료되었습니다.");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
