public class Trade
{
    private String stockTicker;
    private String type;
    private double price;
    private int quantity;
    private int day;

    public Trade(String stockTicker, String type, double price, int quantity, int day)
    {
        this.stockTicker = stockTicker;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.day = day;
    }

    public String getStockTicker()
    {
        return stockTicker;
    }

    public String getType()
    {
        return type;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getDay()
    {
        return day;
    }
}
