import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

// Gson imports
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CryptoConverter {

    // Crypto menu method
    public static void cryptoMenu(Scanner sc, Map<String, Double> rates) {
        System.out.println("\n==== Crypto Menu ====");
        System.out.println("1. Display crypto prices");
        System.out.println("2. Convert amount to crypto");
        System.out.println("3. Back to Main Menu");
        System.out.print("Choose an option: ");

        int choice = sc.nextInt();
        sc.nextLine(); // clean buffer

        switch (choice) {
            case 1:
                displayCryptoPrices();
                break;
            case 2:
                convertAmountToCrypto(sc, rates);
                break;
            case 3:
                return; // back to main menu
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Display live crypto prices from CoinGecko
    public static void displayCryptoPrices() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                        "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum,litecoin&vs_currencies=usd"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonString = response.body();

            JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();

            double btcPrice = json.getAsJsonObject("bitcoin").get("usd").getAsDouble();
            double ethPrice = json.getAsJsonObject("ethereum").get("usd").getAsDouble();
            double ltcPrice = json.getAsJsonObject("litecoin").get("usd").getAsDouble();

            System.out.println("\nLive crypto prices (USD):");
            System.out.printf("Bitcoin (BTC): $%.2f\n", btcPrice);
            System.out.printf("Ethereum (ETH): $%.2f\n", ethPrice);
            System.out.printf("Litecoin (LTC): $%.2f\n", ltcPrice);

        } catch (Exception e) {
            System.out.println("Error fetching crypto prices: " + e.getMessage());
        }
    }

    // Method to convert fiat to crypto
    public static void convertAmountToCrypto(Scanner sc, Map<String, Double> rates) {
        try {
            // Step 1: Ask user for fiat currency and amount
            System.out.print("Enter your fiat currency (EUR/USD/GBP/...): ");
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

            // Step 2: Convert fiat amount to USD
            double amountInUSD = amount;
            if (!sourceCurrency.equals("USD")) {
                if (!rates.containsKey(sourceCurrency)) {
                    System.out.println("Unknown fiat currency.");
                    return;
                }
                amountInUSD = amount / rates.get(sourceCurrency) * rates.get("USD");
            }

            // Step 3: Fetch crypto prices from CoinGecko API
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                        "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum,litecoin&vs_currencies=usd"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonString = response.body();

            JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();

            double btcPrice = json.getAsJsonObject("bitcoin").get("usd").getAsDouble();
            double ethPrice = json.getAsJsonObject("ethereum").get("usd").getAsDouble();
            double ltcPrice = json.getAsJsonObject("litecoin").get("usd").getAsDouble();

            // Step 5: Calculate crypto amounts user can buy
            double btcAmount = amountInUSD / btcPrice;
            double ethAmount = amountInUSD / ethPrice;
            double ltcAmount = amountInUSD / ltcPrice;

            // Step 6: Display results
            System.out.println("\nYou can buy:");
            System.out.printf("BTC: %.8f\n", btcAmount);
            System.out.printf("ETH: %.8f\n", ethAmount);
            System.out.printf("LTC: %.8f\n", ltcAmount);

        } catch (Exception e) {
            System.out.println("Error fetching crypto prices: " + e.getMessage());
        }
    }
}
