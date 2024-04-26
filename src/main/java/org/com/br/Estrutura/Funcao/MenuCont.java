package org.com.br.Estrutura.Funcao;

import java.util.Scanner;

public class MenuCont {
    public MenuCont() {
        Scanner scanner = new Scanner(System.in);
        int menuCont;
        try{
            String MenuCont = """
                    ********************************************
                        Deseja retornar ao menu principal?
                    ---------------------------------------------
                    1) Retornar ao menu principal
                    2) Mais opções
                    3) Histórico de conversões
                    4) Histórico de Logs
                    5) Sair
                    ---------------------------------------------
                        Digite o número da opção desejada: 
                    ********************************************
                    """;
            System.out.println(MenuCont);
            do{
                menuCont = scanner.nextInt();
                switch (menuCont){
                    case 1:
                        new ExecutMenu();
                        break;
                    case 2:
                        System.out.println("Em breve mais opções de conversão!");
                        break;
                    case 3:
                        System.out.println("Em breve histórico de conversões!");
                        break;
                    case 4:
                        System.out.println("Em breve histórico de logs!");
                        break;
                    case 5:
                        System.out.println("Obrigado por utilizar o nosso sistema de conversão de moedas!");
                        break;
                }
            } while (menuCont != 5);
        } catch (RuntimeException e){
            System.out.println("Erro na conexão da API: " + e);
        }
        scanner.close();
    }
}
