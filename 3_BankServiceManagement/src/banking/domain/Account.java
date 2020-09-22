package banking.domain;

public abstract class Account {
    double balance;
    public Account(){

    }
    public Account(double initBalance){
        this.balance=initBalance;
    }

    public double getBalance() {
        return balance;
    }
    public abstract void setBalance(double newBalance);
//    存款 amount：存款额
    public abstract void deposit(double amount);
//    取款
    public abstract void withdraw(double amount)throws OverdraftException;
}
