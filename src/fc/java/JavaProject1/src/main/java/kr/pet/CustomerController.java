package kr.pet;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {customers.add(customer);}

    public Customer findCustomer(String PhoneNumber){
        for(Customer customer : customers){
            if(customer.getPhoneNumber().equals(PhoneNumber)){
                return customer;
            }
        }return null;
    }

    public boolean isPhoneNumberExist(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;


    }

}
