import java.lang.reflect.Array;
import java.util.ArrayList;

/**
    Perform deposit and withdrawal operations on the Bank Account instance.
 */


public class Transaction implements Runnable{
    private String studentName;
    private long studentId;
    private String accountNumber;
    private long balance;

    private ArrayList<BankAccount> accounts;
    private BankAccount bankAccount;

    Thread thread;
    Transaction(ArrayList<BankAccount> accounts, BankAccount bankAccount, long studentId){
        this.accounts = accounts;
        this.bankAccount = bankAccount;
        this.studentId = studentId;

//        for(int a=0; a<accounts.size(); a++){
//            System.out.println(" >> " + this.accounts.get(a).accountNumber);
//        }
        thread = new Thread(this);
        thread.start();
    }

    // optimize search time, if you have enough time
    // use binary search
    private int gettingIndex(long studentId){
        for(int a=0; a<accounts.size(); a++){
            if(accounts.get(a).studentId == studentId){
                return a;
            }
        }

        return -1;
    }

    // deposit
    public void deposit(long ammount){
        if(ammount>0){
            System.out.println("------------------------------------------------");
            System.out.println("    Congratulations!!! Deposit Successfully.     ");
            System.out.println("------------------------------------------------");
            System.out.println("Previous Balance " + balance + " BDT");
            balance+=ammount;
            System.out.println("Deposit "+ ammount + " BDT to " + accountNumber);
            System.out.println("Current Balance " + balance + " BDT");
        }else{
            System.out.println("Invalid deposit ammount. Enter positive ammount");
        }
    }

    // withdraw
    public void withdraw(long ammount){
        if(balance>=ammount){
            System.out.println("--------------------------------------------------");
            System.out.println("    Congratulations!!! Withdraw Successfully.     ");
            System.out.println("--------------------------------------------------");
            System.out.println("Previous Balance " + balance + " BDT");
            balance-=ammount;
            System.out.println("Withdraw "+ ammount + " BDT to " + accountNumber);
            System.out.println("Current Balance " + balance + " BDT");
        }else{
            System.out.println("Your account is empty.");
            System.out.println(accountNumber + " Current Balance " + balance + " BDT");
        }
    }

    // getting balance
    public void getting_balance(){
        System.out.println("--------------------------------------------------");
        System.out.println("                Account Statement                 ");
        System.out.println("--------------------------------------------------");
        System.out.println(accountNumber + " Current Balance " + balance + " BDT");
    }


    // if transaction end
    // then close thread

    @Override
    public void run() {
        System.out.println(" >> hello");
        int index = gettingIndex(studentId);
        synchronized (bankAccount){
            if(index!=-1) {
                System.out.println(index + " == " + studentId);
                this.accountNumber = accounts.get(index).accountNumber;
                bankAccount.order(this);
            }else{
                System.out.println("Student ID is Invalid");
                // thread stop
            }
        }
    }
}