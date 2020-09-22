package banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Customer> customers;
    public Bank(){
        customers=new ArrayList<Customer>();
    }
    public void addCustomer(String firstName,String lastName){
        customers.add(new Customer(firstName,lastName));
    }
    public Customer getCustomer(int customer_index){
        return customers.get(customer_index);
    }
    public int getNumOdCustomers(){
        return customers.size();
    }
    public List<Customer> getCustomers(){
        return this.customers;
    }

}
