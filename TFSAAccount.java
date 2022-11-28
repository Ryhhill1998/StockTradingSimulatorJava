public class TFSAAccount extends Account
{
    public TFSAAccount(String firstName, String surname, double balance) {
        super(firstName, surname, balance);
        buyFeeMultiplier = 0.01;
        sellFeeMultiplier = 0.01;
    }
}
