package kr.book.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RentalRecord {

    private String Userid;
    private String ISBN;
    private LocalDate RentDay;
    private LocalDate ReturnDay;
    private boolean RentAvaiable;


    public String getId() {
        return Userid;
    }

    public void setId(String id) {
        this.Userid = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;


    }

    public LocalDate getRentDay() {
        return RentDay;
    }

    public void setRentDay(LocalDate rentDay) {
        RentDay = rentDay;
    }

    public LocalDate getReturnDay() {
        return ReturnDay;
    }

    public void setReturnDay(LocalDate returnDay) {
        ReturnDay = returnDay;
    }

    public void setReturnDay(LocalDateTime returnDay) {
        if(returnDay != null) {}
    }


    public boolean isRentAvaiable() {
        return RentAvaiable;
    }

    public void setRentAvaiable(boolean rentAvaiable) {
        RentAvaiable = rentAvaiable;
    }

    public RentalRecord (String id, String isbn,  LocalDate rentDay, LocalDate returnDay, boolean rentAvaiable) {
        this.Userid = id;
        ISBN = isbn;
        RentDay = rentDay;
        ReturnDay = returnDay;
        RentAvaiable = rentAvaiable;
    }

    public RentalRecord(){};


}


