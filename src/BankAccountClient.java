import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class BankAccountClient {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private BankAccountClient() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        BankAccount bankAccount = new BankAccount();

        out.print("Insert a new account name: ");
        String accountName = in.nextLine();

        bankAccount.createAccount(accountName);

        out.println();
        out.print("Insert an amount to deposit: ");
        double depositAmount = in.nextDouble();

        bankAccount.deposit(accountName, depositAmount);

        out.println();
        out.print("Insert an amount to deposit: ");
        double withdrawAmount = in.nextDouble();

        bankAccount.withdraw(accountName, withdrawAmount);

        /*
         * Put your main program code here
         */
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
