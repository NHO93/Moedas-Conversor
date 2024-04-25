package org.com.br.Estrutura;// Classe ConversorMoedas
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class ConversorMoedas {

    public static void converterMoeda
            (String moedaOrigem, String moedaDestino)
            throws IOException, URISyntaxException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor em " + moedaOrigem + ": ");
        double valorOrigem = scanner.nextDouble();

        double taxaDeCambio = API.obterTaxaDeCambio
                (moedaOrigem, moedaDestino);

        if (taxaDeCambio < 0) {
            System.out.println("Erro ao obter a taxa de câmbio.");
            return;
        }

        double valorConvertido = valorOrigem * taxaDeCambio;

        System.out.println
                (valorOrigem + " " + moedaOrigem + " equivalem a "
                        + valorConvertido + " " + moedaDestino);
    }

    public static void moedaUSDparaEUR() {
        try {
            ConversorMoedas.converterMoeda("USD", "EUR");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moedaEURparaUSD() {
        try {
            ConversorMoedas.converterMoeda("EUR", "USD");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moedaUSDparaGBP() {
        try {
           ConversorMoedas.converterMoeda("USD", "GBP");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moedaGBPparaUSD() {
        try {
            ConversorMoedas.converterMoeda("GBP", "USD");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moedaEURparaGBP() {
        try {
            ConversorMoedas.converterMoeda("EUR", "GBP");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moedaGBPparaEUR() {
        try {
            ConversorMoedas.converterMoeda("GBP", "EUR");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moedaBRLparaUSD() {
        try {
            ConversorMoedas.converterMoeda("BRL", "USD");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moedaUSDparaBRL() {
        try {
            ConversorMoedas.converterMoeda("USD", "BRL");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moedaBRLparaEUR() {
        try {
            ConversorMoedas.converterMoeda("BRL", "EUR");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moedaEURparaBRL() {
        try {
            ConversorMoedas.converterMoeda("EUR", "BRL");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moedaBRLparaGBP() {
        try {
            ConversorMoedas.converterMoeda("BRL", "GBP");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moedaGBPparaBRL() {
        try {
            ConversorMoedas.converterMoeda("GBP", "BRL");
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}