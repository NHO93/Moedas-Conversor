package org.com.br.Estrutura.Funcao;

import java.util.Scanner;

public class Menu {
    public Menu(){
        Scanner sc = new Scanner(System.in);
        Scanner leituraNomeCliente = new Scanner(System.in);
        System.out.println("Bom dia, seja bem vindo ao nosso sistema de vendas!"
                + "\nPor favor informe o seu nome: ");
        String nomeCliente = leituraNomeCliente.nextLine();
        System.out.println("\nOlá " + nomeCliente + ", utilize o nosso" +
                "Conversor de Moedas para saber o valor de uma moeda em outra.");

        new ExecutMenu();
    }
}
