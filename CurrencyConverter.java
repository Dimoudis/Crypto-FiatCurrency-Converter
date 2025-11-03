import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Rates (fiat) relative to EUR 
        Map<String, Double> rates = new HashMap<>();
        rates.put("EUR", 1.0);  
        rates.put("USD", 1.1); 
        rates.put("GBP", 0.85); 
        rates.put("JPY", 150.0); 
        rates.put("CHF", 0.98); 
        rates.put("CAD", 1.5);  
        rates.put("AUD", 1.6);  

        while (true) {
            System.out.println("\n==== Main Menu ====");
            System.out.println("1. Fiat Currency Conversion");
            System.out.println("2. Crypto Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clean buffer

            switch (choice) {
                case 1:
                    FiatConverter.fiatConversion(sc, rates); // πρέπει να υπάρχει η static μέθοδος fiatConversion
                    break;
                case 2:
                    CryptoConverter.cryptoMenu(sc, rates); // πρέπει να υπάρχει η static μέθοδος cryptoMenu
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;               
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }   
    }
}
