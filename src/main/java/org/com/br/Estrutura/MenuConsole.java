package org.com.br.Estrutura;

import java.util.Scanner;

public class MenuConsole {
        public MenuConsole(){
            Scanner scanner = new Scanner(System.in);
            Scanner leituraNomeCliente = new Scanner(System.in);
            System.out.println("Prezado(a) cliente, informe o seu nome: ");
            String nomeCliente = leituraNomeCliente.nextLine();
            System.out.println("Olá, " + nomeCliente + ", utilize o nosso " +
                    "Conversor de Moedas através do menu abaixo:");

            new ExecutaMenuConsole();
        }
    }