package org.com.br.Estrutura;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;


public class CurrencyConverter {
    private static final String API_KEY = "76e817442e7bc981ba9d77ad";
    private static final String API_URL = "https://open.er-api.com/v6/latest/";

    public static double convertCurrency
            (String fromCurrency, String toCurrency, double amount)
            throws IOException {

        String endereco = API_URL + fromCurrency;
        URL url = new URL(endereco);

        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader
                (new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject jsonObject = new JSONObject(response.toString());

        double rate = jsonObject.getJSONObject
                ("rates").getDouble(toCurrency);

        return amount * rate;
    }
}