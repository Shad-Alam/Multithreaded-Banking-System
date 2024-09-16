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

    // search index using student ID
    static int gettingIndex(ArrayList<BankAccount> accounts, String studentId){
        for(int a=0; a<accounts.size(); a++){
            if(accounts.get(a).studentId==studentId){
                return a;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
        bankAccounts.add(new BankAccount("Masruk Ahmed Ruhani","2019000000019", "Account_001", 157500));
        bankAccounts.add(new BankAccount("Shad Alam Joy","2019000000059", "Account_003", 126000));


        BankAccount bankAccount = new BankAccount();
        String studentID = "2019000000059";
        int index = gettingIndex(bankAccounts, studentID);
        if(index != -1) {
            Transaction transaction1 = new Transaction(bankAccounts, bankAccount, studentID, index);

            try {
                transaction1.thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Invalid Student ID.");
        }

        // Print the final balances of all accounts after all threads have finished
        System.out.println("=======================================================================");
        System.out.println(" ::                 Final Balance of all accounts                   :: ");
        System.out.println("=======================================================================");

        for(int a=0; a<bankAccounts.size(); a++){
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(" >> Student Name    ::   " + bankAccounts.get(a).getStudentName());
            System.out.println(" >> Account Number  ::   " + bankAccounts.get(a).getAccountNumber());
            System.out.println(" >> Student ID      ::   " + bankAccounts.get(a).getStudentId());
            System.out.println(" >> Balance         ::   " + bankAccounts.get(a).getBalance() + " BDT");
            System.out.println("-----------------------------------------------------------------------");
        }
    }
}

