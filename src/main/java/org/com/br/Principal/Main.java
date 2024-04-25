package org.com.br.Principal;

import org.com.br.Estrutura.CurrencyConverter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Moedas disponíveis para conversão:\n"+
                    "\nUSD - Dólar Americano" +
                    "\nEUR - Euro" +
                    "\nGBP - Libra Esterlina" +
                    "\nBRL - Real Brasileiro" +
                    "\nARS - Peso Argentino" +
                    "\nCHF - Franco Suíço");
        System.out.print("\nInsira o valor a ser convertido: ");
        double amount = scanner.nextDouble();

        System.out.print("\nInsira a moeda de origem (USD, EUR, GBP, BRL, ARS, CHF): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("\nInsira a moeda de destino (USD, EUR, GBP, BRL, ARS, CHF): ");
        String toCurrency = scanner.next().toUpperCase();

        try {
            double result = CurrencyConverter.convertCurrency(fromCurrency, toCurrency, amount);
            System.out.printf("\n%.2f %s = %.2f %s%n", amount, fromCurrency, result, toCurrency);
        } catch (IOException e) {
            System.out.println("\nErro ao converter moeda. Por favor, tente novamente mais tarde.");
        }

        scanner.close();
        System.out.println("\nObrigado por usar o Conversor de Moedas!");
    }
}