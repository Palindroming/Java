package com.example.restapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookqueryparam {
    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;

    // Getter와 Setter
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIssuedYear() {
        return issuedYear;
    }

    public void setIssuedYear(String issuedYear) {
        this.issuedYear = issuedYear;
    }

    public String getIssuedMonth() {
        return issuedMonth;
    }

    public void setIssuedMonth(String issuedMonth) {
        this.issuedMonth = issuedMonth;
    }

    public String getIssuedDay() {
        return issuedDay;
    }

    public void setIssuedDay(String issuedDay) {
        this.issuedDay = issuedDay;
    }

    @Override
    public String toString() {
        return "bookqueryparam{" +
                "category='" + category + '\'' +
                ", issuedYear='" + issuedYear + '\'' +
                ", issuedMonth='" + issuedMonth + '\'' +
                ", issuedDay='" + issuedDay + '\'' +
                '}';
    }
}
