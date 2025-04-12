package rpg.Jogo;

import rpg.Personagem.main_characters.DrMorato;
import rpg.Personagem.main_characters.Liz;
import rpg.Personagem.main_characters.Personagem;
import rpg.exceptions.InvalidUserInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoInterface {

    public void start () {

        Scanner sc = new Scanner(System.in);

        System.out.println("Texto de escolha pro personagem");

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

                    DrMorato drMorato = new DrMorato();

                    System.out.println("Escolheu: " + drMorato);

                    return drMorato;

                case 2:

                    Liz liz = new Liz();

                    System.out.println("Escolheu: " + liz);

                    return liz;

                default:

                    System.out.println("Erro!");

                    break;

            }

        } catch (IllegalArgumentException | InputMismatchException ex) {

            throw new InvalidUserInputException(ex.getMessage());

        }

        return null;

    }

}
