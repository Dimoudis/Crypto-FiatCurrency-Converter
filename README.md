CurrencyCryptoConverter

A simple Java application that allows users to:

- Convert between different fiat currencies (EUR, USD, GBP, JPY, CHF, CAD, AUD).
- View live cryptocurrency prices (BTC, ETH, LTC) fetched directly from the CoinGecko API.
- Convert fiat amounts to cryptocurrency based on current market prices.

Features:

- Live crypto price fetching using HTTP requests and Gson for JSON parsing.
- Login system with username/password validation.
- Display of login attempts with timestamp, username, and password in the browser console.
- Redirect to the main application page upon successful login.
- Main application page includes:
  - Fiat currency converter.
  - Cryptocurrency menu for live prices and conversion.
- Frontend designed with responsive and clean UI, using styled buttons and sections.

Dependencies:

- Java 11+ (for HttpClient)
- Gson library (included in `libs/gson-2.10.1.jar`)

Screenshots: 
(screenshot of the console showing login attempts)
<img width="1861" height="1079" alt="image" src="https://github.com/user-attachments/assets/c3e0099e-9fdd-4934-b21b-a3fc0d07dc4c" />
