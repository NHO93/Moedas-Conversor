package org.com.br.Estrutura;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Map;

public class CurrencyConverter {
    private static final String API_KEY = "76e817442e7bc981ba9d77ad";
    private static final String API_URL = "https://open.er-api.com/v6/latest/";

    public static double convertCurrency(String fromCurrency, String toCurrency, double amount) throws IOException {
        String urlString = API_URL + fromCurrency;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject jsonObject = new JSONObject(response.toString());
        double rate = jsonObject.getJSONObject("rates").getDouble(toCurrency);
        return amount * rate;
    }

    public static String main(String[] args) {
        try {
            String moedaRecebida = "";
            String chaveApiKey = "76e817442e7bc981ba9d77ad";
            final URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + chaveApiKey + "/latest/" + moedaRecebida);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            if (response.statusCode() == 200) {
                System.out.println("Erro na conexão: " + response.statusCode());
            }
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            MoedaRecebida moedaRecebidaObj = gson.fromJson(json, MoedaRecebida.class);
            String moedaConvertida = "";
            double valorConversao = 0;
            double coinValue = getCoinValue(moedaConvertida, valorConversao, moedaRecebidaObj);
            String coinValueFinal = formatValue(coinValue);
            String valueFinal = formatValue(valorConversao);

            return "O valor de " + moedaRecebida + " " + valueFinal + " é igual a "
                    + moedaConvertida + " " + coinValueFinal + ".";
        } catch (IOException e) {
            throw new RuntimeException("Erro na conexão com a API: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new RuntimeException("Conexão com a API interrompida: " + e.getMessage(), e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro inesperado: " + e.getMessage(), e);
        }
    }

    private static double getCoinValue(String moedaConvertida, double valorConversao, @NotNull MoedaRecebida moedaRecebidaObj) {
        Map<String, Double> conversorMoedas = moedaRecebidaObj.conversionRates();
        if (conversorMoedas == null || conversorMoedas.isEmpty()) {
            throw new RuntimeException("Erro ao converter moedas");
        }
        Double taxaConversao = conversorMoedas.get(moedaConvertida);
        if (taxaConversao == null) {
            throw new RuntimeException("Erro na taxa de conversão das moedas");
        }
        return valorConversao * taxaConversao;
    }

    private static String formatValue(double valorConversao) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(valorConversao);
    }
}