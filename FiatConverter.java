import java.util.Map;
import java.util.Scanner;

public class FiatConverter {

    public static void fiatConversion(Scanner sc, Map<String, Double> rates) {
        System.out.print("Enter the currency you have (EUR/USD/GBP/...): ");
        String sourceCurrency = sc.nextLine().toUpperCase();

        double amount = -1;
        while (true) {
            System.out.print("Enter the amount: ");
            try {
                amount = sc.nextDouble();
                if (amount > 0) break;
                else System.out.println("Invalid amount. Must be positive.");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // clean buffer
            }
        }
        sc.nextLine(); // consume newline

        System.out.print("Enter the target currency (EUR/USD/GBP/...): ");
        String targetCurrency = sc.nextLine().toUpperCase();

        if (!rates.containsKey(sourceCurrency) || !rates.containsKey(targetCurrency)) {
            System.out.println("Sorry, cannot convert to/from that currency.");
        } else {
            double amountInEUR = amount / rates.get(sourceCurrency);
            double convertedAmount = amountInEUR * rates.get(targetCurrency);
            System.out.println(amount + " " + sourceCurrency + " = " +
            String.format("%.1f", amountInEUR) + " EUR = " +
            String.format("%.4f", convertedAmount) + " " + targetCurrency);
        }
    }
}
