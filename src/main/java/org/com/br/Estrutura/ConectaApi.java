package org.com.br.Estrutura;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Map;

public class ConectaApi {
    public String paraConverter(String moedaRecebida, String moedaConvertida,
                                double valorConversao) throws ConnectException {
        final String chaveApiKey = "76e817442e7bc981ba9d77ad"; //Sua Chave De API Aqui;

        try {
            final URI uri = URI.create("\"https://v6.exchangerate-api.com/v6/" + chaveApiKey +
                    "/latest/" + moedaRecebida);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            if (response.statusCode() == 200) {
                System.out.println("Erro na conexão: "+ response.statusCode());
            }
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            MoedaRecebida moedaRecebidaObj = gson.fromJson(json, MoedaRecebida.class);
            double coinValue = getCoinValue(moedaConvertida, valorConversao, moedaRecebidaObj);
            String coinValueFinal = formatValue(coinValue);
            String valueFinal = formatValue(valorConversao);

            return "O valor de " + moedaRecebida + " " + valueFinal + " é igual a "
                    + moedaConvertida + " " + coinValueFinal + ".";
        } catch (IOException  e) {
            throw new RuntimeException("Erro na conexão com a API: " + e.getMessage(),e);
        } catch (InterruptedException e) {
            throw new RuntimeException("Conexão com a API interrompida: " + e.getMessage(), e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro inesperdao: " + e.getMessage(), e);
        }
    }
private static double getCoinValue(String moedaConvertida, double valorConversao,
                                   @NotNull MoedaRecebida moedaRecebidaObj) {
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
    private String formatValue(double valorConversao) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(valorConversao);
    }
}