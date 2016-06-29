import java.util.Random;

/**
 * Created by praveenkumaralam on 1/9/16.
 */
public class JavaConc implements Runnable {
    private BankAccount  account = new BankAccount();
    @Override
    public void run() {
        System.out.println("Java Concurrency Example");
        while(account.getBalance()>0){
            if(account.getBalance() <0) System.out.println(" balance is negative");
            account.withdrawMoney(10);

        }

    }
    public static void main(String[] args){
        JavaConc r = new JavaConc();
        Thread johnThread = new Thread(r);
        Thread kenThread = new Thread(r);
        johnThread.setName("John");
        johnThread.start();

        kenThread.setName("Ken");
        kenThread.start();
    }
}
class BankAccount{
    private int balance=0;
    int randomnumber = 0;
    public BankAccount(){
        balance = 100;
        Random rand = new Random(100);
        randomnumber = rand.nextInt();
    }
    synchronized  public int withdrawMoney(int amt){
        System.out.println(Thread.currentThread().getName()+" withdrawing money "+balance);
        //if(amt > balance) return 0;
        //else
        balance -= amt;
        return amt;
    }
    public int getBalance(){
        System.out.println(Thread.currentThread().getName()+" checking balance "+balance);
        return balance;
    }
}
