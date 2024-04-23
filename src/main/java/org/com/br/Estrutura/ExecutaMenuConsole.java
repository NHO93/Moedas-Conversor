package org.com.br.Estrutura;

import java.net.ConnectException;
import java.util.Scanner;

public class ExecutaMenuConsole {
    public ExecutaMenuConsole() {
        Scanner scanner = new Scanner(System.in);
        int opcaoMenuConsole;

        ConectaApi conectaApi = new ConectaApi();

        try {
            String MenuConsole = """
                    ********************************************
                                        Menu
                    --------------------------------------------
                                Escolha Uma Opção!
                    ********************************************
                    1 - Dolar (USD) ==========> Real Brasil (BRL)
                    2 - Euro (EUR) ===========> Real Brasil (BRL)
                    3 - Yuan China (CNY) =====> Real Brasil (BRL)
                    4 - Franco Suíço (CHF) ====> Real Brasil (BRL)
                    5 - Libra Esterlina (GBP) => Real Brasil (BRL)
                    6 - Iene Japonês (JPY) ====> Real Brasil (BRL)
                    7 - Historico de Conversão
                    8 - Sair
                    ********************************************
                    """;
            System.out.println(MenuConsole);
            do {
                opcaoMenuConsole = scanner.nextInt();

                switch (opcaoMenuConsole) {
                    case 1:
                        System.out.println("Quanto deseja converter de Dolar para Real?");
                        double valorConversao = scanner.nextDouble();


                        System.out.println("A convrsão foi realizada com sucesso!");

                        String resultado = conectaApi.paraConverter("USD", "BRL", valorConversao);
                        System.out.println(resultado);

                        new ExecutaMenuConsole();

                        break;
                    case 2:
                        System.out.println("Quanto deseja converter de Euro para Real?");
                        valorConversao = scanner.nextDouble();

                        System.out.println("A convrsão foi realizada com sucesso!");
                        resultado = conectaApi.paraConverter("EUR","BRL", valorConversao);
                        System.out.println(resultado);

                        new ExecutaMenuConsole();
                        break;
                    case 3:
                        System.out.println("Quanto deseja converter de Yuan China para Real?");
                        valorConversao = scanner.nextDouble();

                        System.out.println("A convrsão foi realizada com sucesso!");
                        resultado = conectaApi.paraConverter("CNY", "BRL", valorConversao);
                        System.out.println(resultado);

                        new ExecutaMenuConsole();
                        break;
                    case 4:
                        System.out.println("Quanto deseja converter de Franco Suíço para Real?");
                        valorConversao = scanner.nextDouble();

                        System.out.println("A convrsão foi realizada com sucesso!");
                        resultado = conectaApi.paraConverter("CHF", "BRL", valorConversao);
                        System.out.println(resultado);

                        new ExecutaMenuConsole();
                        break;
                    case 5:
                        System.out.println("Quanto deseja converter de Libra Esterlina para Real?");
                        valorConversao = scanner.nextDouble();

                        System.out.println("A convrsão foi realizada com sucesso!");
                        resultado = conectaApi.paraConverter("GBP", "BRL",  valorConversao);
                        System.out.println(resultado);

                        new ExecutaMenuConsole();
                        break;
                    case 6:
                        System.out.println("Quanto deseja converter de Iene Japonês para Real?");
                        valorConversao = scanner.nextDouble();

                        System.out.println("A convrsão foi realizada com sucesso!");
                        resultado = conectaApi.paraConverter("JPY", "BRL", valorConversao);
                        System.out.println(resultado);

                        new ExecutaMenuConsole();
                        break;
                    case 7:
                        System.out.println("Em breve mais opções estarão disponíveis!");
                        break;
                    case 8:
                        System.out.println("Saindo do Sistema...");
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
            } while (opcaoMenuConsole != 8);
            scanner.close();
        } catch (ConnectException e) {
            System.out.println("Erro ao conectar com a API!: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro ao acessar a API!: " + e.getMessage());
        }
    }
}