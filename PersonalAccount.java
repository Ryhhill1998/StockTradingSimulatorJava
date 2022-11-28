public class PersonalAccount extends Account
{
    public PersonalAccount(String name, double balance)
    {
        super(name, balance);
        buyFeeMultiplier = 0;
        sellFeeMultiplier = 0.05;
    }
}
