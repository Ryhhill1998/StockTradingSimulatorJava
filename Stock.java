import java.util.HashMap;

public class Stock
{
    private String ticker;
    private HashMap<Integer, Double> priceData;

    public Stock(String ticker)
    {
        this.ticker = ticker;
        priceData = new HashMap<>();
    }

    public String getTicker()
    {
        return ticker;
    }

    public double getPrice(int day)
    {
        return priceData.get(day);
    }

    public String getDetails(int day) {
        return String.format("Ticker: %s, Price: $%.2f", ticker, getPrice(day));
    }

    public boolean addPriceData(int day, double price)
    {
        if (priceData.containsKey(day))
            return false;

        priceData.put(day, price);
        return true;
    }
}
