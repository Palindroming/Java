package kr.pet;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordController {

    public List<MedicalRecord> medicalRecordList = new ArrayList<>();
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordList.add(medicalRecord);
    }

    public List<MedicalRecord> findMedicalRecordList(String PhoneNumber) {
        for(MedicalRecord medicalRecord : medicalRecordList) {
            if(medicalRecord.getPhoneNumber().equals(PhoneNumber)) {
                medicalRecordList.add(medicalRecord);
            }
        }return medicalRecordList;


    }

    public void removeMedicalRecord(String PhoneNumber) {
       for(MedicalRecord medicalRecord : medicalRecordList) {
           if(medicalRecord.getPhoneNumber().equals(PhoneNumber)) {
               medicalRecordList.remove(medicalRecord);
           }
       }
    }

}
