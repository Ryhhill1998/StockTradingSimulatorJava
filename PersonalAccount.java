public class PersonalAccount extends Account
{
    public PersonalAccount(String firstName, String surname, double balance)
    {
        super(firstName, surname, balance);
        buyFeeMultiplier = 0;
        sellFeeMultiplier = 0.05;
    }
}
