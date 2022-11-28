import java.util.HashMap;

public abstract class Account
{
    private String firstName;
    private String surname;
    private double balance;
    private int dayCreated;
    private HashMap<String, Integer> portfolio;
    private HashMap<Trade, Double> tradeHistory;
    protected double buyFeeMultiplier;
    protected double sellFeeMultiplier;

    public Account(String firstName, String surname, double balance, int day)
    {
        this.firstName = firstName;
        this.surname = surname;
        this.balance = balance;
        portfolio = new HashMap<>();
        tradeHistory = new HashMap<>();
        dayCreated = day;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public double getBalance() {
        return balance;
    }

    public int getDayCreated() {
        return dayCreated;
    }

    public boolean buyShares(String stockTicker, double stockPrice, int quantity, int day)
    {
        double transactionCost = (buyFeeMultiplier + 1) * stockPrice * quantity;

        // check if account has a high enough balance to process this transaction
        if (balance < transactionCost)
            return false;

        // reduce account balance by transaction cost
        balance -= transactionCost;

        // update portfolio to contain the new number of shares for this stock
        int sharesHeld = getSharesHeld(stockTicker);
        int updatedShares = sharesHeld + quantity;
        portfolio.put(stockTicker, updatedShares);

        // add trade to trade history
        addTradeToHistory(stockTicker, "MARKET_BUY", stockPrice, quantity, day);

        return true; // transaction successful
    }

    public boolean sellShares(String stockTicker, double stockPrice, int quantity, int day)
    {
        // check account has enough shares for this stock in its portfolio
        int sharesHeld = getSharesHeld(stockTicker);

        // account does not have enough shares for this stock to process sale
        if (sharesHeld < quantity)
            return false;

        // get money returned from sale minus any fees
        double moneyReturned = (1 - sellFeeMultiplier) * stockPrice * quantity;

        // add money return to account balance
        balance += moneyReturned;

        // update portfolio to contain the new number of shares for this stock
        int updatedShares = sharesHeld - quantity;
        portfolio.put(stockTicker, updatedShares);

        // add trade to trade history
        addTradeToHistory(stockTicker, "MARKET_SELL", stockPrice, quantity, day);

        return true; // transaction successful
    }

    private int getSharesHeld(String ticker)
    {
        return portfolio.getOrDefault(ticker, 0);
    }

    private void addTradeToHistory(String ticker, String type, double price, int quantity, int day)
    {
        tradeHistory.put(new Trade(ticker, type, price, quantity, day), balance);
    }

    @Override
    public String toString()
    {
        return "Name: " + firstName + " " + surname + ", Portfolio: " + portfolio.toString() +
                ", Balance: " + balance;
    }
}
