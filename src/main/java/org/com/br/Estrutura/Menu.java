package org.com.br.Estrutura;
import java.util.Scanner;

public class Menu {

    public static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. USD para EUR");
        System.out.println("2. EUR para USD");
        System.out.println("3. USD para GBP");
        System.out.println("4. GBP para USD");
        System.out.println("5. EUR para GBP");
        System.out.println("6. GBP para EUR");
        System.out.println("7. BRL para USD");
        System.out.println("8. USD para BRL");
        System.out.println("9. BRL para EUR");
        System.out.println("10. EUR para BRL");
        System.out.println("11. BRL para GBP");
        System.out.println("12. GBP para BRL");

        System.out.println("0. Sair");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                ConversorMoedas.moedaUSDparaEUR();
                break;
            case 2:
                ConversorMoedas.moedaEURparaUSD();
                break;
            case 3:
                ConversorMoedas.moedaUSDparaGBP();
                break;
            case 4:
                ConversorMoedas.moedaGBPparaUSD();
                break;
            case 5:
                ConversorMoedas.moedaEURparaGBP();
                break;
            case 6:
                ConversorMoedas.moedaGBPparaEUR();
                break;
            case 7:
                ConversorMoedas.moedaBRLparaUSD();
                break;
            case 8:
                ConversorMoedas.moedaUSDparaBRL();
                break;
            case 9:
                ConversorMoedas.moedaBRLparaEUR();
                break;
            case 10:
                ConversorMoedas.moedaEURparaBRL();
                break;
            case 11:
                ConversorMoedas.moedaBRLparaGBP();
                break;
            case 12:
                ConversorMoedas.moedaGBPparaBRL();
                break;
            case 0:
                System.out.println("Obrigado por usar o Conversor de Moedas. Até mais!");
                return;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }
    }
}
