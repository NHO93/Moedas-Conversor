package org.com.br.Estrutura;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class API {
    private static final String API_URL =
            "https://v6.exchangerate-api.com/v6//latest/USD";

    public static double obterTaxaDeCambio(String moedaOrigem, String moedaDestino)
            throws IOException, InterruptedException, URISyntaxException, JSONException {

        String urlString = API_URL + "&symbols=" + moedaDestino;
        URI uri = URI.create(urlString);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> response = client.send
                (request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {

            JSONObject responseJson = new JSONObject(response.body());

            JSONObject rates = responseJson.getJSONObject("rates");

            return rates.getDouble(moedaDestino);
        } else {
            System.out.println
                    ("Erro na requisição: " + response.statusCode());
            return -1.0;
        }
    }
}

