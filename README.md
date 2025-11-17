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


# Fiat & Crypto Converter Web Application

This project is a web-based interface for a currency and cryptocurrency converter built with Java for the backend logic and HTML/CSS/JavaScript for the frontend.

## Features

- Login system with username/password validation.
- Display of login attempts with timestamp, username, and password in the browser console.
- Redirect to the main application page upon successful login.
- Main application page includes:
  - Fiat currency converter.
  - Cryptocurrency menu for live prices and conversion.
- Frontend designed with responsive and clean UI, using styled buttons and sections.

## How to Use 

1. Open `login.html` in your browser.
2. Use the following credentials to login successfully:
   - Username: `user`
   - Password: `123gr`
3. Any login attempt (successful or failed) will be logged in the browser console.
4. Successful login redirects to the main application page (`app.html`) where all conversion features are available.

## Notes

- The login console output is useful for testing and tracking user actions.
- Take a screenshot of the console to verify login attempts and timestamp logs.
- The frontend is fully static and requires a backend server (e.g., Spring Boot) to connect with the Java logic for real conversions.

## Screenshots

(screenshot of the console showing login attempts here)
<img width="1861" height="793" alt="image" src="https://github.com/user-attachments/assets/6f897b51-549f-41d4-a678-6e2963b0b557" />
![Uploading image.png…]()

