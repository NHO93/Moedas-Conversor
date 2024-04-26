package org.com.br.Estrutura.Funcao;

import org.com.br.Estrutura.Conectar.ConectApi;

import java.net.ConnectException;
import java.util.Scanner;

public class ExecutMenu {
    public ExecutMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcaoMenu;

        ConectApi conectApi = new ConectApi();

        try{
            String OpcaoMenu = """
                   \n
                   ***********************************************
                                  Menu de opções
                   ***********************************************
                   1) Dolar (USD) --------------> Real (BRL)
                   2) Euro (EUR) --------------> Real (BRL)
                   3) Peso Argentino (ARS) -----> Real (BRL)
                   4) Yuan China (CNY) ---------------> Real (BRL)
                   5) Real (BRL) --------------> Dolar (USD)
                   6) Real (BRL) --------------> Euro (EUR)
                   7) Real (BRL) --------------> Peso Argentino (ARS)
                   8) Real (BRL) --------------> Yuan China (CNY)
                   9) Mais opções de conversão
                   10) Histórico de conversões
                   11) Sair
                   ***********************************************
                     Digite a opção desejada:
                   ***********************************************
                   """;
            System.out.println(OpcaoMenu);
            do {
                opcaoMenu = scanner.nextInt();
                switch (opcaoMenu) {
                    case 1:
                        System.out.println("Qual o valor a ser convertido? ");
                        double valorConversao = scanner.nextDouble();

                        String resultado = conectApi.paraConverter
                                ("USD", "BRL", valorConversao);
                        System.out.println(resultado);
                        new ExecutMenu();
                        break;
                    case 2:
                        System.out.println("Qual o valor a ser convertido? ");
                        valorConversao = scanner.nextDouble();

                        resultado = conectApi.paraConverter
                                ("EUR", "BRL", valorConversao);
                        System.out.println(resultado);
                        new ExecutMenu();
                        break;
                    case 3:
                        System.out.println("Qual o valor a ser convertido? ");
                        valorConversao = scanner.nextDouble();

                        resultado = conectApi.paraConverter
                                ("ARS", "BRL", valorConversao);
                        System.out.println(resultado);
                        new ExecutMenu();
                        break;
                    case 4:
                        System.out.println("Qual o valor a ser convertido? ");
                        valorConversao = scanner.nextDouble();

                        resultado = conectApi.paraConverter
                                ("CNY", "BRL", valorConversao);
                        System.out.println(resultado);
                        new ExecutMenu();
                        break;
                    case 5:
                        System.out.println("Qual o valor a ser convertido? ");
                        valorConversao = scanner.nextDouble();

                        resultado = conectApi.paraConverter
                                ("BRL", "USD", valorConversao);
                        System.out.println(resultado);
                        new ExecutMenu();
                        break;
                    case 6:
                        System.out.println("Qual o valor a ser convertido? ");
                        valorConversao = scanner.nextDouble();

                        resultado = conectApi.paraConverter
                                ("BRL", "EUR", valorConversao);
                        System.out.println(resultado);
                        new ExecutMenu();
                        break;
                    case 7:
                        System.out.println("Qual o valor a ser convertido? ");
                        valorConversao = scanner.nextDouble();

                        resultado = conectApi.paraConverter
                                ("BRL", "ARS", valorConversao);
                        System.out.println(resultado);
                        new ExecutMenu();
                        break;
                    case 8:
                        System.out.println("Qual o valor a ser convertido? ");
                        valorConversao = scanner.nextDouble();

                        resultado = conectApi.paraConverter
                                ("BRL", "CNY", valorConversao);
                        System.out.println(resultado);
                        new ExecutMenu();
                        break;
                    case 9:
                        System.out.println("Mais opções de conversão em breve estará disponível");
                        break;
                    case 10:
                        System.out.println("Histórico de conversões em breve estará disponível");
                        break;
                    case 11:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente");
                        break;
                }
            }while (opcaoMenu != 11) ;
            scanner.close();
        }catch(ConnectException e){
            System.out.println("Erro de conexão com a API: " + e.getMessage());
        } catch(RuntimeException e){
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}