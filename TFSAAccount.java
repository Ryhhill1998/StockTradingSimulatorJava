public class TFSAAccount extends Account
{
    public TFSAAccount(String firstName, String surname, double balance, int day) {
        super(firstName, surname, balance, day);
        buyFeeMultiplier = 0.01;
        sellFeeMultiplier = 0.01;
    }
}
