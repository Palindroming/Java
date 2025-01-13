package kr.book.Controller;



import kr.book.Model.*;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    List<Book> bookList = new ArrayList<>();

    public Book findBookByTitle(String title){

        for(Book book: bookList){
            if(book.getTitle().equals(title)){
                return book;
            }
        }

        return null;
    }

    public Book addBook(String isbn, String title, String author){
        Book book = findBookByTitle(title);
        if(book != null){
            book = new Book(isbn,title,author);
            bookList.add(book);
            return book;
        }
        return null;

    }




    }


