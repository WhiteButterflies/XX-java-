package banking.domain;

public class CheckingAccount extends Account {
//    能透支是true
    boolean canOverdraft=false;
    double maxOverdraft=0.0;
    public CheckingAccount(double initBalace){
        this.balance=initBalace;
        this.maxOverdraft=0.0;
        this.canOverdraft=false;
    }
    public CheckingAccount(double initBalance,boolean canOverdraft,double maxOverdraft){
        this.balance=initBalance;
        this.canOverdraft=canOverdraft;
        this.maxOverdraft=maxOverdraft;
    }
    @Override
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    @Override
    public void deposit(double amount) {
        this.balance+=amount;
        System.out.println("充值"+amount);

    }

    @Override
    public void withdraw(double amount) throws OverdraftException {
        if(amount<=(this.balance+maxOverdraft)){
            if(amount<=this.balance){
                balance-=amount;
            }else if(canOverdraft) {
                System.out.println("透支开始");
                maxOverdraft=maxOverdraft+balance-amount;
                balance=0;
            }
            System.out.println("支取"+amount);
        }else if(!canOverdraft){
            throw new OverdraftException();
        }
    }
}
