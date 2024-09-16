import java.util.ArrayList;

/**
    Perform deposit and withdrawal operations on the Bank Account instance.
 */

public class Transaction implements Runnable{
    private String studentId;
    private String accountNumber;
    private ArrayList<BankAccount> accounts;
    private BankAccount bankAccount;
    public int index;

    Thread thread;
    Transaction(ArrayList<BankAccount> accounts, BankAccount bankAccount, String studentId, int index){
        this.accounts = accounts;
        this.bankAccount = bankAccount;
        this.studentId = studentId;
        this.index = index;

        thread = new Thread(this);
        thread.start();
    }

    // deposit
    public void deposit(int amount, int index){
        if(amount>0){
            System.out.println("======================================================");
            System.out.println(" ::    Congratulations!!! Deposit Successfully.    :: ");
            System.out.println("======================================================");

            System.out.println(" >> Previous Balance :: " + accounts.get(index).balance + " BDT");
            accounts.get(index).balance+=amount;
            System.out.println(" >> Deposit          :: "+ amount + " BDT to " + accounts.get(index).accountNumber);
            System.out.println(" >> Current Balance  :: " + accounts.get(index).balance + " BDT");
        }else{
            System.out.println(" >> Invalid deposit ammount. Enter positive ammount");
        }
    }

    // withdraw
    public void withdraw(int amount, int index){
        if(accounts.get(index).balance>=amount){
            System.out.println("=======================================================");
            System.out.println(" ::    Congratulations!!! Withdraw Successfully.    :: ");
            System.out.println("=======================================================");

            System.out.println(" >> Previous Balance  :: " + accounts.get(index).balance + " BDT");
            accounts.get(index).balance-=amount;
            System.out.println(" >> Withdraw          :: "+ amount + " BDT from Account Number :: " + accounts.get(index).accountNumber);
            System.out.println(" >> Current Balance   :: " + accounts.get(index).balance + " BDT");
        }else{
            System.out.println(" >> Your account is balance less than                         :: " + accounts.get(index).balance + " BDT");
            System.out.println(" >> " + accounts.get(index).accountNumber + " Current Balance :: " + accounts.get(index).balance + " BDT");
        }
    }

    // getting balance
    public void getting_balance(int index){
        System.out.println("==================================================");
        System.out.println(" ::               Account Statement            :: ");
        System.out.println("==================================================");
        System.out.println(" >> Account Number    :: "+ accounts.get(index).accountNumber);
        System.out.println(" >> Current Balance   :: " + accounts.get(index).balance + " BDT");
    }

    @Override
    public void run() {
        synchronized (bankAccount){
            if(index!=-1) {
                this.accountNumber = accounts.get(index).accountNumber;
                bankAccount.order(this);
            }else{
                System.out.println("Student ID is Invalid");
            }
        }
    }
}