import java.util.Scanner;

class BankAccount {
    public String studentName;
    public String studentId;
    public String accountNumber;
    public int balance;

    BankAccount(){

    }

    BankAccount(String studentName, String studentId, String accountNumber, int initialBalance){
        this.studentName = studentName;
        this.studentId = studentId;
        this.balance = initialBalance;
        this.accountNumber = accountNumber;
    }

    // display operation number
    private void display(){
        System.out.println("==========================================");
        System.out.println("==========================================");
        System.out.println("    Account Operations ::");
        System.out.println("      >> Enter 1 for Deposit");
        System.out.println("      >> Enter 2 for Withdraw");
        System.out.println("      >> Enter 3 for Getting Balance");
        System.out.println("      >> Enter 0 for Quit Transaction");
        System.out.println("==========================================");
        System.out.println("==========================================");
    }

    // user activity controller
    public void order(Transaction transaction){
        Scanner in = new Scanner(System.in);
        int n, ammount, index = transaction.index;
        while (true){
            display();
            System.out.print("Enter operation number :: ");
            n = in.nextInt();
            if(n==0){
                // quit()
                System.out.println(">> Thanks for your Transaction.");
                break;
            }else if(n==1){
                // deposit
                System.out.print("Enter Deposit Amount :: ");
                ammount = in.nextInt();
                transaction.deposit(ammount, index);
            }else if(n==2){
                // withdraw
                System.out.print("Enter Withdraw Amount :: ");
                ammount = in.nextInt();
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

    public String getStudentId() {
        return studentId;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}