package ExceptionHandling.Account;

import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accounts = new HashMap<>();


    public void addAccount(String owner, double balance, double overdraftFrame) throws BankException {
        if (accounts.containsKey(owner)) {
            throw new BankException("Account existiert bereits");
        }
        Account account = new Account(owner, balance, overdraftFrame);
        accounts.put(owner, account);
    }

    public void transfer(String fromOwner, String toOwner, double amount) throws AccountNotFoundException, BankException {
        if (!accounts.containsKey(fromOwner) || !accounts.containsKey(toOwner)) {
            throw new AccountNotFoundException();
        }

        Account fromAccount = accounts.get(fromOwner);
        Account toAccount = accounts.get(toOwner);

        try {
            fromAccount.debit(amount);
            toAccount.credit(amount);
        } catch (NotEnoughMoneyException e) {
            throw new BankException("Transfer nicht möglich", e);
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "accounts=" + accounts +
                '}';
    }
}
