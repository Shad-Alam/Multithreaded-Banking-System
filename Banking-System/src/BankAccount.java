import java.util.Random;
import java.util.Scanner;

class BankAccount {
    public String studentName;
    public long studentId;
    public String accountNumber;
    public long balance;

    BankAccount(){

    }

    BankAccount(String studentName, long studentId, long initialBalance){
        this.studentName = studentName;
        this.studentId = studentId;
        this.balance = initialBalance;
        this.accountNumber = "Account_";
        Random random = new Random();

        for(int a=0; a<10; a++){
            int n = random.nextInt(10);
            this.accountNumber += String.valueOf(n);
        }
    }
/**
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
        if(balance>0){
            System.out.println("--------------------------------------------------");
            System.out.println("    Congratulations!!! Withdraw Successfully.     ");
            System.out.println("--------------------------------------------------");
            System.out.println("Previous Balance " + balance + " BDT");
            balance+=ammount;
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

*/
    private void display(){
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("    Account Operations ::");
        System.out.println("      >> Enter 1 for Deposit");
        System.out.println("      >> Enter 2 for Withdraw");
        System.out.println("      >> Enter 3 for Getting Balance");
        System.out.println("      >> Enter 0 for Quit Transaction");
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
    }


    public void order(Transaction transaction){
        Scanner in = new Scanner(System.in);
        int n;
        long ammount;
        String ac;
        boolean port = false;
        int index = transaction.index;
        while (true){
            display();
            n = in.nextInt();
            if(n==0){
                // quit()
                System.out.println(">> Thanks for your Transaction.");
                break;
            }else if(n==1){
                // deposit
                ammount = in.nextLong();
                transaction.deposit(ammount, index);
            }else if(n==2){
                // withdraw
                ammount = in.nextLong();
                transaction.withdraw(ammount, index);
            }else if(n==3){
                // getting balance
                transaction.getting_balance(index);
            }
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public long getStudentId() {
        return studentId;
    }

    public long getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}