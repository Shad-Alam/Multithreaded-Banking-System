import java.util.ArrayList;

/***
Initialize Accounts
○ Create instances of Bank Account with initial balances.
        ● Create and Manage Threads
○ Create instances of Transaction Thread with different operations.
        ○ Use a thread pool or manage threads manually to execute
operations.
● Collect and Display Results
○ Print the final balances of all accounts after all threads have finished
executing.
        Note: These are suggestions, you can improvise the system if required.
 */

public class BankSystem {
    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
        bankAccounts.add(new BankAccount("Shad",2029, 12));
        bankAccounts.add(new BankAccount("Suad",2026, 12));
        bankAccounts.add(new BankAccount("Raad",2027, 12));
        bankAccounts.add(new BankAccount("Nill",2031, 12));
        bankAccounts.add(new BankAccount("Upra",2028, 12));
        bankAccounts.add(new BankAccount("Thor",2020, 12));

        BankAccount bankAccount = new BankAccount();
        long studentID = 2027;
        Transaction transaction1 = new Transaction(bankAccounts, bankAccount, studentID);

        for(int a=0; a<bankAccounts.size(); a++){
            System.out.println(bankAccounts.get(a).accountNumber + " >> " + bankAccounts.get(a).studentId + " >> " + bankAccounts.get(a).balance);
        }
    }
}

