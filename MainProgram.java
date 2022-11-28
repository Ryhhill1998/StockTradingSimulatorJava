import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainProgram
{
    public static void main(String[] args) {
        TradingPlatform tp = new TradingPlatform();

        try
        {
            loadStockData(tp, "data/AAPL.csv");
            loadStockData(tp, "data/FB.csv");
            loadStockData(tp, "data/GOOG.csv");
            loadStockData(tp, "data/TSLA.csv");

            loadAccountData(tp, "data/accounts.csv");
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        boolean continueSimulation = true;

        while (continueSimulation)
        {
            printMenu();
            continueSimulation = getSelection(tp);
        }
    }

    private static void loadStockData(TradingPlatform tp, String filePath) throws FileNotFoundException
    {
        File file = new File(filePath);
        Scanner scanFile = new Scanner(file);

        String ticker = scanFile.nextLine();
        tp.addStock(ticker);

        while (scanFile.hasNextLine())
        {
            String[] dailyPriceInfo = scanFile.nextLine().split(",");
            tp.addStockData(ticker, Integer.parseInt(dailyPriceInfo[0]), Double.parseDouble(dailyPriceInfo[1]));
        }
    }

    private static void loadAccountData(TradingPlatform tp, String filePath) throws FileNotFoundException
    {
        File file = new File(filePath);
        Scanner scanFile = new Scanner(file);

        while (scanFile.hasNextLine())
        {
            String[] accountDetails = scanFile.nextLine().split(",");
            tp.registerAccount(accountDetails[0], accountDetails[1],
                    Double.parseDouble(accountDetails[2]), accountDetails[3]);
        }
    }

    private static void printMenu()
    {
        System.out.println("MENU");
        System.out.println("----------------------------------------");
        System.out.println("Please select one of the options below:\n" +
                "\n\ta - Show account details" +
                "\n\ts - Show stock details" +
                "\n\tb - Buy shares" +
                "\n\tr - Sell shares" +
                "\n\tt - Sim to day" +
                "\n\tx - Exit\n");
    }

    private static boolean getSelection(TradingPlatform tp)
    {
        Scanner scan = new Scanner(System.in);
        String option = scan.next();

        boolean continueSimulation = true;

        switch (option)
        {
            case "a":
                // print account details
                printAccountDetails(tp);
                break;
            case "s":
                // print stock details
                printStockDetails(tp);
                break;
            case "b":
                // allow user to buy shares
                break;
            case "r":
                // allow user to sell shares
                break;
            case "t":
                // allow user to sell shares
                break;
            case "x":
                // exit simulation
                continueSimulation = false;
        }

        return continueSimulation;
    }

    private static void printAccountDetails(TradingPlatform tp)
    {
        System.out.println(tp.getAccountDetails());
    }

    private static void printStockDetails(TradingPlatform tp)
    {
        System.out.println(tp.getStockDetails());
    }
}
