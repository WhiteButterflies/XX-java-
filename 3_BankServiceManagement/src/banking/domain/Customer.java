package banking.domain;

import java.util.ArrayList;

public class Customer {
    String firstName;
    String lastName;
    ArrayList<Account> accounts;
    public Customer(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        accounts = new ArrayList<Account>();
    }
    public String getName(){
        return firstName+" "+lastName;
    }
    public void addAccount(Account acct){
        this.accounts.add(acct);
    }
    public Account getAccount(int account_index){
        return this.accounts.get(account_index);
    }
    public int getNumOfAccounts(){
        return this.accounts.size();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
