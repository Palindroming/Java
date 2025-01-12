package kr.excel.example;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelExample {

    public static void main(String[] args) {
        try {

            FileInputStream fis = new FileInputStream(new File("example.xlsx"));
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheetAt(0);
            for(Row row : sheet) {
                for(Cell cell : row) {
                    System.out.print(cell.toString()+"\t");
                }
                System.out.println();
            }
            fis.close();
            System.out.println("Success at reading excel file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } {

        }
    }
}
