package banking.domain;

public class SavingsAccount extends Account {
    double interestRate=0;
    public SavingsAccount(double initBalance,double interestRate){
//        注意一下这个super
        super(initBalance);
        this.interestRate=interestRate;
    }
    @Override
    public void setBalance(double newBalance) {
        this.balance=newBalance;
    }

    @Override
    public void deposit(double amount) {
        this.balance+=amount;
        System.out.println("充值"+amount);
    }

    @Override
    public void withdraw(double amount) throws OverdraftException {
        if(amount>balance){
//            透支异常触发
            throw new OverdraftException();
        }
        else{
            balance-=amount;
            System.out.println("已经成功支取了"+amount+"元");
        }

    }

}
