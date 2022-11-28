public class TFSAAccount extends Account
{
    public TFSAAccount(String name, double balance)
    {
        super(name, balance);
        buyFeeMultiplier = 0.01;
        sellFeeMultiplier = 0.01;
    }
}
