classDiagram
    class Customer {
        - String phoneNumber
        - String ownerName
        - String petName
        - String address
        - String species
        - int birthYear
    }

    class MedicalRecord {
        - String phoneNumber
        - String date
        - String content
    }

    class CustomerController {
        + addCustomer(Customer)
        + findCustomer(String): Customer
        + removeCustomer(String)
    }

    class MedicalRecordController {
        + addMedicalRecord(MedicalRecord)
        + findMedicalRecords(String): List~MedicalRecord~
        + removeMedicalRecord(String)
    }

    class ConsoleView {
        + String getPhoneNumber()
        + Customer getCustomerInfo()
        + MedicalRecord getMedicalRecordInfo()
        + void printMedicalRecordInfo(Customer, List~MedicalRecord~)
        + void printMessage(String)
    }

    class MainController {
        + handleRequest(int)
    }

    class PetMain {
        main(String[])
    }

    CustomerController --> Customer
    MedicalRecordController --> MedicalRecord
    MainController --> CustomerController
    MainController --> MedicalRecordController
    MainController --> ConsoleView
    PetMain --> MainController
    ConsoleView ..> Customer
    ConsoleView ..> MedicalRecord
