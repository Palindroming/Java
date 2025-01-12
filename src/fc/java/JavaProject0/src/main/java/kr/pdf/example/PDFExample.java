package kr.pdf.example;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PDFExample {
    public static void main(String[] args) {
        try {
            // PDF 문서 생성
            Document document = new Document();

            // PdfWriter 객체 생성 (팩토리 메서드 사용)
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));

            // 문서 열기
            document.open();
            document.add(new com.itextpdf.text.Paragraph("Hello, PDF!"));

            // 문서 닫기
            document.close();

            System.out.println("PDF created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
