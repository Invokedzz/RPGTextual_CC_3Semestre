package rpg.Jogo;

import rpg.Personagem.main_characters.DrMorato;
import rpg.Personagem.main_characters.Liz;
import rpg.Personagem.main_characters.Personagem;
import rpg.exceptions.InvalidUserInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoInterface {

    public void start () {
        DrMorato escolha1 = new DrMorato();
        Liz escolha2 = new Liz();

        Scanner sc = new Scanner(System.in);

        System.out.println("Personagens que podem ser escolhidos: ");
        System.out.println("--------------------------------------------------");
        System.out.print(escolha1.escolha());
        System.out.println("--------------------------------------------------");
        System.out.print(escolha2.escolha());
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





}
