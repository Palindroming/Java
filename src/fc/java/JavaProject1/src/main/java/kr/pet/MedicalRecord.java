package kr.pet;

public class MedicalRecord {

    private String phoneNumber;
    private String RecordDate;
    private String content;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRecordDate() {
        return RecordDate;
    }

    public void setRecordDate(String recordDate) {
        RecordDate = recordDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MedicalRecord(String phoneNumber, String recordDate, String content) {
        this.phoneNumber = phoneNumber;
        this.RecordDate = recordDate;
        this.content = content;
    }
}
