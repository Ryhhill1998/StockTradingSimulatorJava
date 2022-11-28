import java.util.ArrayList;

public class TradingPlatform
{
    private ArrayList<Account> registeredAccounts;
    private ArrayList<Stock> availableStocks;
    private int simulationDay;

    public TradingPlatform()
    {
        registeredAccounts = new ArrayList<>();
        availableStocks = new ArrayList<>();
        simulationDay = 1;
    }

    public boolean registerAccount(String firstName, String surname, double balance, String type)
    {
        // first check if a customer with this name is already registered
        if (findAccountIndex(firstName, surname) != -1)
            return false;

        Account newAccount;

        if (type.equals("PERSONAL"))
            newAccount = new PersonalAccount(firstName, surname, balance, simulationDay);
        else if (type.equals("TFSA"))
            newAccount = new TFSAAccount(firstName, surname, balance, simulationDay);
        else
            return false; // invalid account type

        return registeredAccounts.add(newAccount);
    }

    private int findAccountIndex(String firstName, String surname)
    {
        for (int i = 0; i < registeredAccounts.size(); i++)
        {
            Account acc = registeredAccounts.get(i);
            if (acc.getFirstName().equals(firstName) && acc.getSurname().equals(surname))
                return i;
        }

        return -1;
    }

    public boolean closeAccount(String firstName, String surname)
    {
        // find account index in registered accounts
        int accountIndex = findAccountIndex(firstName, surname);

        // if account not found return false
        if (accountIndex == -1)
            return false;

        registeredAccounts.remove(accountIndex);
        return true;
    }

    public boolean addStock(String ticker)
    {
        if (findStockIndex(ticker) != -1)
            return false;

        return availableStocks.add(new Stock(ticker));
    }

    public boolean addStockData(String ticker, int day, double price)
    {
        int stockIndex = findStockIndex(ticker);

        if (stockIndex == -1)
            return false;

        return availableStocks.get(stockIndex).addPriceData(day, price);
    }

    public boolean processTrade(String firstName, String surname, String ticker, String type, int quantity)
    {
        int accountIndex = findAccountIndex(firstName, surname);

        // if account not found, return false
        if (accountIndex == -1)
            return false;

        int stockIndex = findStockIndex(ticker);

        // if stock not found, return false
        if (stockIndex == -1)
            return false;

        Account account = registeredAccounts.get(accountIndex);
        Stock stock = availableStocks.get(stockIndex);

        if (type.equals("BUY"))
            return account.buyShares(ticker, stock.getPrice(simulationDay), quantity, simulationDay);
        else if (type.equals("SELL"))
            return account.sellShares(ticker, stock.getPrice(simulationDay), quantity, simulationDay);
        else
            return false; // invalid trade type
    }

    private int findStockIndex(String ticker)
    {
        for (int i = 0; i < availableStocks.size(); i++)
        {
            Stock stock = availableStocks.get(i);
            if (stock.getTicker().equals(ticker))
                return i;
        }

        return -1;
    }

    public boolean simToDay(int newSimulationDay)
    {
        if (newSimulationDay <= simulationDay || newSimulationDay > 2160)
            return false;

        simulationDay = newSimulationDay;
        return true;
    }

    public String getAccountDetails()
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (Account acc : registeredAccounts)
            stringBuilder.append(acc.toString()).append("\n");

        return stringBuilder.toString();
    }

    public String getStockDetails()
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (Stock s : availableStocks)
            stringBuilder.append(s.getDetails(simulationDay)).append("\n");

        return stringBuilder.toString();
    }
}
