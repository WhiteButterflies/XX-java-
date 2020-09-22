package banking.domain;

public class TestBanking {
    public static void main(String[] args) {
        Bank bank=new Bank();
        bank.addCustomer("Jane","Aimms");
        bank.addCustomer("Owen","Bryant");
        bank.addCustomer("Tim","Soley");
        bank.addCustomer("Maria","Soley");
        bank.getCustomers().get(0).addAccount(new SavingsAccount(500.0,0.05));
        bank.getCustomers().get(0).addAccount(new CheckingAccount(200,true,400));
        bank.getCustomers().get(1).addAccount(new CheckingAccount(200));
        bank.getCustomers().get(2).addAccount(new SavingsAccount(1500.0,0.05));
        bank.getCustomers().get(2).addAccount(new CheckingAccount(300.0));
        bank.getCustomers().get(3).addAccount(new SavingsAccount(150.0,0.05));
        bank.getCustomers().get(3).addAccount(bank.getCustomers().get(2).getAccount(1));
        CustomerReport.generateReport(bank);
    }
}
