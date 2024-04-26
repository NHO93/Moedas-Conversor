package org.com.br.Estrutura.Conectar;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.com.br.Estrutura.Valores.MoedaRecebida;

import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Map;

public class ConectApi {
    public String paraConverter
            (String moedaRecebida, String moedaComvertida, double valorConversao)
            throws ConnectException {
        final String chaveApiKey = "Sua chave aqui";

        try {
            final URI uri = new URI
                    ("https://v6.exchangerate-api.com/v6/" + chaveApiKey + "/latest/" + moedaRecebida);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(uri)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            if (response.statusCode() != 200) {
                throw new ConnectException("Erro ao conectar com a API");
            }
            Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            MoedaRecebida moedaRecebidaObj = gson.fromJson(json, MoedaRecebida.class);
            double coinValue = getCoinValue(moedaComvertida, valorConversao, moedaRecebidaObj);
            String coinValueFinal = formatValue(coinValue);
            String valueFinal = formatValue(valorConversao);

            return "O valor de " + moedaRecebida+ " " +coinValueFinal +
                    " é igual a " + moedaComvertida + " " + coinValueFinal;

        } catch (URISyntaxException e) {
            throw new RuntimeException("Erro de I/O ao acessar API:  " + e.getMessage(), e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Conexao Interrompida " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Erro: " + e.getMessage(), e);
        }
    }
    private static double getCoinValue
            (String moedaComvertida, double valorConversao, MoedaRecebida moedaRecebidaObj) {
        Map<String, Double> conversorMoedas = moedaRecebidaObj.conversionRates();

        if (conversorMoedas == null || conversorMoedas.isEmpty()) {
            throw new RuntimeException("Erro ao converter moedas");
        }
        Double taxaConversao = conversorMoedas.get(moedaComvertida);
        if (taxaConversao == null) {
            throw new RuntimeException("Moeda de conversão não encontrada");
        }
        return valorConversao * taxaConversao;
    }
    private String formatValue(double valorConversao) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(valorConversao);
    }
}