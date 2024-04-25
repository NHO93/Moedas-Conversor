package org.com.br.Principal;

import org.com.br.Estrutura.Menu;


public class ConversorDeMoedas {

    public static void main(String[] args) {
        exibirBoasVindas();
        Menu.exibirMenu();
    }

    public static void exibirBoasVindas() {
        System.out.println("Bem-vindo ao Conversor de Moedas!\n"
                + "Com este programa, você pode converter valores entre diferentes moedas.\n"
                + "Escolha uma opção no menu abaixo para começar.\n"
                + "Para sair, digite 0.\n"
                + "Vamos lá!");
    }
}
