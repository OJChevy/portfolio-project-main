import components.map.Map1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class BankAccount extends Map1L<String, Double> {

    private static Map1L<String, Double> overallAccount;

    /*
     * Kernel Methods ---------------------------------------------------------
     */

    /**
     * The purpose of this method is to create a new account within the overall
     * account based on an account name.
     *
     * @param accountName
     *            The name of the account
     */
    public void createAccount(String accountName) {

        this.add(accountName, 0.00);

    }

    /**
     * The purpose of this method is to check if an account exists.
     *
     * @param accountName
     *            The name of the account
     * @return true if the account with that name exists, false otherwise
     */
    public final boolean accountExists(String accountName) {

        boolean foundAccount = false;

        if (this.hasKey(accountName)) {

            foundAccount = true;

        }

        return foundAccount;

    }

    /**
     * The purpose of this method is to deposit an amount into a certain
     * account.
     *
     * @param accountName
     *            The name of the account
     * @param amount
     *            The amount to deposit
     */
    public void deposit(String accountName, double amount) {

        assert this
                .hasKey(accountName) != false : "Violation of: Account exists";

        if (this.hasKey(accountName)) {

            double currentAmount = this.value(accountName);

            double newAmount = currentAmount + amount;

            this.replaceValue(accountName, newAmount);

            System.out.println("Amount after deposit: " + newAmount);

        }

    }

    private void createNewRep() {

        this.overallAccount = new Map1L<String, Double>();

    }

    /*
     * Constructor ------------------------------------------------------------
     */

    public BankAccount() {

        this.createNewRep();

    }

    /**
     * The purpose of this method is to withdraw an amount from a certain
     * account.
     *
     * @param accountName
     *            The name of the account
     * @param amount
     *            The amount to withdraw
     */
    public final void withdraw(String accountName, double amount) {

        assert this
                .hasKey(accountName) != false : "Violation of: Account exists";

        if (this.hasKey(accountName)) {

            double currentAmount = this.value(accountName);

            double newAmount = currentAmount - amount;

            this.replaceValue(accountName, newAmount);

            System.out.println("Amount after withdraw: " + newAmount);

        }

    }

}
