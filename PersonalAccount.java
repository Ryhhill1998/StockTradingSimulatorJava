public class PersonalAccount extends Account
{
    public PersonalAccount(String firstName, String surname, double balance, int day)
    {
        super(firstName, surname, balance, day);
        buyFeeMultiplier = 0;
        sellFeeMultiplier = 0.05;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: PERSONAL";
    }
}
