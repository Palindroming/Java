package kr.book.Controller;

import kr.book.Model.RentalRecord;

import java.time.LocalDate;
import java.util.*;

public class RentalController {

    List<RentalRecord> rentalRecordList = new ArrayList<>();
    RentalRecord rentalRecord = new RentalRecord();


    public RentalRecord addRentalRecord(String id, String isbn,  LocalDate RentDay) {

        rentalRecord = new RentalRecord(id,isbn,RentDay,null,false);
        rentalRecordList.add(rentalRecord);
        return rentalRecord;
    }

    public RentalRecord returnRentalRecord(String id, String isbn, LocalDate rentDay, LocalDate returnDay) {
        for (RentalRecord record : rentalRecordList) {
            if (record.getId().equals(id) && record.getISBN().equals(isbn)) {
                record.setReturnDay(returnDay); // 반납일 업데이트
                record.setRentAvaiable(true); // 대여 가능 상태로 변경
                return record;
            }
        }
        return null; // 기록을 찾지 못한 경우
    }



    public RentalRecord findRecordsByUser(String Userid){
        for(RentalRecord rentalRecord : rentalRecordList){
            if(rentalRecord.getId().equals(Userid)){
                return rentalRecord;
            }
        }
        return null;
    }










}

