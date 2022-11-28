import java.time.LocalDate;

public class Trade
{
    private String stockTicker;
    private String type;
    private double price;
    private int quantity;
    private LocalDate date;

    public Trade(String stockTicker, String type, double price, int quantity)
    {
        this.stockTicker = stockTicker;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        date = LocalDate.now();
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

    public LocalDate getDate()
    {
        return date;
    }
}
