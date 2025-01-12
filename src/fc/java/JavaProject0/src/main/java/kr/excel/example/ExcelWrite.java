package kr.excel.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcelWrite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("enter your name: ");
        String name = scanner.nextLine();

        System.out.print("enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("enter your birthday: ");
        String birthday = scanner.nextLine();

        System.out.print("enter your phone number: ");
        String phone = scanner.nextLine();

        System.out.print("enter your address: ");
        String address = scanner.nextLine();

        System.out.print("are you married?: ");
        boolean isMarried = scanner.nextBoolean();

        Member member = new Member(name,age,birthday,phone,address,isMarried);


        try{
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("User Info");

            Row HeaderRow = sheet.createRow(0);
            HeaderRow.createCell(0).setCellValue(member.getName());
            HeaderRow.createCell(1).setCellValue(member.getAge());
            HeaderRow.createCell(2).setCellValue(member.getBirthday());
            HeaderRow.createCell(3).setCellValue(member.getPhone());
            HeaderRow.createCell(4).setCellValue(member.getAddress());
            HeaderRow.createCell(5).setCellValue(member.isMarried());

            String Filename = "members.xlsx";
            FileOutputStream output = new FileOutputStream(new File(Filename));
            workbook.write(output);
            output.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }


}
