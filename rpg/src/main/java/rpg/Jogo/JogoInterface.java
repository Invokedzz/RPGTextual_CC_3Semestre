package rpg.Jogo;

import rpg.Personagem.main_characters.DrMorato;
import rpg.Personagem.main_characters.Liz;
import rpg.Personagem.main_characters.Personagem;
import rpg.exceptions.InvalidUserInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoInterface {
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public void start () {
        DrMorato escolha1 = new DrMorato();
        Liz escolha2 = new Liz();

        Scanner sc = new Scanner(System.in);

        String texto1 = VERDE + "[ACESSANDO TERMINAL DA RESISTÊNCIA VERDE...]\n" +
        "\n" +
                ">> Conexão segura estabelecida.\n" +
                "\n" +
                ">> Identidade confirmada. Acesso de campo liberado.\n" +
                "\n" +
                ">> Carregando perfil dos agentes disponíveis para a missão final: OPERAÇÃO RAIZ...\n" +
                "\n" +
                ">> Apenas dois membros ativos estão aptos para a infiltração nos Núcleos Verdes.\n" + RESET;

        printSlowlyWithSound(texto1, 50);

        String pausa;
        pausa = sc.nextLine();

        System.out.println("Personagens que podem ser escolhidos: ");
        System.out.println("--------------------------------------------------");
        printSlowly(escolha1.escolha(), 25);
        System.out.println("--------------------------------------------------");
        printSlowly(escolha2.escolha(), 25);
        System.out.println("--------------------------------------------------");
        System.out.print("Escolha a opção desejada (1/2):");



        int choice = sc.nextInt();

        Personagem chosenCharacter = chooseYourCharacter(choice);

        if (chosenCharacter != null) {

            System.out.println(chosenCharacter);

        }



    }

    private Personagem chooseYourCharacter (int choice) {

        try {

            switch (choice) {

                case 1:

                    return new DrMorato();

                case 2:

                    return new Liz();

                default:

                    System.out.println("Opção escolhida invalida!");

                    break;

            }

        } catch (IllegalArgumentException | InputMismatchException ex) {

            throw new InvalidUserInputException(ex.getMessage());

        }

        return null;

    }

    public static void printSlowly(String text, long delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  // boa prática
            }
        }
        System.out.println();  // pular linha no final
    }

    public static void printSlowlyWithSound(String text, long delayMillis) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush();

            if (c == ' ') {
                SomInterface.playBeep(); // Toca o beep só quando for espaço
            }

            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();

        SomInterface.fecharBeep(); // <- FECHA O SOM AQUI!

    }





}
