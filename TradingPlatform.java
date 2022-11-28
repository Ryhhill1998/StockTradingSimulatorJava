import java.util.ArrayList;

public class TradingPlatform
{
    private ArrayList<Account> registeredAccounts;
    private ArrayList<Stock> availableStocks;

    public TradingPlatform()
    {
        registeredAccounts = new ArrayList<>();
        availableStocks = new ArrayList<>();
    }

    public boolean registerAccount(String firstName, String surname, double balance, String type)
    {
        // first check if a customer with this name is already registered

        Account newAccount;

        if (type.equals("PERSONAL"))
            newAccount = new PersonalAccount(firstName, surname, balance);
        else if (type.equals("TFSA"))
            newAccount = new TFSAAccount(firstName, surname, balance);
        else
            return false;

        registeredAccounts.add(newAccount);
        return true;
    }
}
