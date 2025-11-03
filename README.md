# CurrencyCryptoConverter

A simple Java application that allows users to:

- Convert between different fiat currencies (EUR, USD, GBP, JPY, CHF, CAD, AUD).
- View live cryptocurrency prices (BTC, ETH, LTC) fetched directly from the CoinGecko API.
- Convert fiat amounts to cryptocurrency based on current market prices.

## Features

- Interactive command-line interface.
- Live crypto price fetching using HTTP requests and Gson for JSON parsing.
- Easy to extend for more fiat currencies or additional cryptocurrencies.

## Usage

1. Open a terminal and navigate to the project folder.
2. Compile the project with:
javac -cp libs\gson-2.10.1.jar *.java

3. Run the program with:
java -cp libs\gson-2.10.1.jar;. CurrencyConverter

4. Follow the on-screen menu to convert currencies or view crypto prices.

## Dependencies

- Java 11+ (for HttpClient)
- Gson library (included in `libs/gson-2.10.1.jar`)
