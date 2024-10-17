import java.util.Map;

/**
 * {@code BankAccountKernel} enhanced with secondary methods.
 */
public interface BankAccount extends BankAccountKernel {

    enum AccountType {

        CHECKING, SAVINGS

    };

    void addToBankStatement(Map<String, Double> info);

    /**
     * The purpose of this method is to add several deposits to either the
     * checking or savings account.
     *
     * @param accountType
     *            the account to add the money to.
     *
     * @param depositSlip
     *            a {@code Map} with multiple deposits to add to the account.
     */
    void depositMultiple(AccountType accountType,
            Map<String, Double> depositSlip);

    /**
     * The purpose of this method is to withdraw several amounts from either the
     * checking or savings account.
     *
     * @param accountType
     *            the account to remove the money from
     *
     * @param withdrawSlip
     *            a {@code Map} with the withdraw amounts
     */
    void withdrawMultiple(AccountType accountType,
            Map<String, Double> withdrawSlip);

    /**
     * The purpose of this method is to transfer money from one account to
     * another.
     *
     * @param transferAccount
     *            the account to transfer money from
     *
     * @param receiveAccount
     *            the account that will receive the money
     *
     * @param amount
     *            the amount of money that will be transferred
     */
    void transfer(AccountType transferAccount, AccountType receiveAccount,
            double amount);

    /**
     * The purpose of this method is to "withdraw" money and pay another party.
     *
     * @param accountType
     *            the account to withdraw the money from
     *
     * @param receiver
     *            the name of the party receiving the money
     *
     * @param amount
     *            the amount of money that will be sent
     */
    void pay(AccountType accountType, String receiver, double amount);

    /**
     * The purpose of this method is to print the bank statement of the user's
     * accounts to the terminal in a readable format.
     */
    void getBankStatement();

}
