package org.com.br.Estrutura;

import java.util.Scanner;

public class ExecutaSubMenuConsole {
    public void ExecutaMenuConsole(){
        Scanner scanner = new Scanner(System.in);
        int opcaoMenuConsole;

        try{
            String SubMenuConsole = """
                    ********************************************
                          Deseja retornar ao Menu anterior
                    --------------------------------------------
                            ou realizar novas operações?
                    ********************************************
                    1 - Retornar ao Menu Anterior
                    2 - Realizar Nova Operação
                    3 - Historico de Conversão
                    4 - Historico de Logs
                    5 - Sair
                    ********************************************
                                Escolha Uma Opção!
                    --------------------------------------------
                    """;
            System.out.println(SubMenuConsole);
            do{
                opcaoMenuConsole = scanner.nextInt();

                switch(opcaoMenuConsole){
                    case 1:
                        new ExecutaMenuConsole();
                        break;
                    case 2:
                        System.out.println("Em breve mais opções!");
                        break;
                    case 3:
                        System.out.println("Em breve o histórico de conversão!");
                        break;
                    case 4:
                        System.out.println("Em breve o histórico de logs!");
                        break;
                    case 5:
                        System.out.println("Saindo do Sistema!");
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
            } while(opcaoMenuConsole != 5);
        } catch (Exception e) {
            System.out.println("Erro ao acessar a API:2 " + e.getMessage());
        }
        scanner.close();
    }
}
