import java.util.Map;

import components.standard.Standard;

/**
 * Bank Account kernel component with primary methods. (Note: by package-wide
 * convention, all references are non-null.
 *
 *
 */
public interface BankAccountKernel extends Standard<Map> {

    /**
     * The purpose of this method is to create a new account within the overall
     * account based on an account name.
     *
     * @param accountName
     *            The name of the account
     */
    void createAccount(String accountName);

    /**
     * The purpose of this method is to check if an account exists.
     *
     * @param accountName
     *            The name of the account
     * @return true if the account with that name exists, false otherwise
     */
    boolean accountExists(String accountName);

    /**
     * The purpose of this method is to deposit an amount into a certain
     * account.
     *
     * @param accountName
     *            The name of the account
     * @param amount
     *            The amount to deposit
     */
    void deposit(String accountName, double amount);

    /**
     * The purpose of this method is to withdraw an amount from a certain
     * account.
     *
     * @param accountName
     *            The name of the account
     * @param amount
     *            The amount to withdraw
     */
    void withdraw(String accountName, double amount);

}
