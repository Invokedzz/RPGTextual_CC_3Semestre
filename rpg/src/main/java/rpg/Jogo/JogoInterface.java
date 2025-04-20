package rpg.Jogo;

import rpg.Personagem.enemies.Mobs;
import rpg.Personagem.enemies.Skill;
import rpg.Personagem.enemies.skills.None;
import rpg.Personagem.main_characters.DrMorato;
import rpg.Personagem.main_characters.Liz;
import rpg.Personagem.main_characters.Personagem;
import rpg.Util.FileReader;
import rpg.exceptions.InvalidUserInputException;

import java.util.*;

public class JogoInterface {
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public String pausa;

    public void start () {
        DrMorato escolha1 = new DrMorato();
        Liz escolha2 = new Liz();

        Scanner sc = new Scanner(System.in);

        printSlowly(Objects.requireNonNull(FileReader.readTxtFile("Texto.txt")), 2);

        System.out.println("--------------------------------------------------");

        pausa = sc.nextLine();

        String texto1 = VERDE
                + "[ACESSANDO TERMINAL DA RESISTÊNCIA VERDE...]\n"
                + "\n"
                + ">> Conexão segura estabelecida.\n"
                + "\n"
                + ">> Identidade confirmada. Acesso de campo liberado.\n"
                + "\n"
                + ">> Carregando perfil dos agentes disponíveis para a missão final: OPERAÇÃO RAIZ...\n"
                + "\n"
                + ">> Apenas dois membros ativos estão aptos para a infiltração nos Núcleos Verdes.\n"
                + "\n"
                + ">> Escolha obrigatória para iniciar a missão.\n"
                + "\n"
                + ">> Apenas um agente poderá seguir com você nesta operação.\n"
                + "\n"
                + ">> ATENÇÃO: Sua escolha influenciará sua jornada.\n"
                + "\n"
                + RESET;

        printSlowlyWithSound(texto1, 2);

        pausa = sc.nextLine();

        System.out.println("Personagens que podem ser escolhidos: ");
        System.out.println("--------------------------------------------------");
        printSlowly(escolha1.escolha(), 2);
        System.out.println("--------------------------------------------------");
        printSlowly(escolha2.escolha(), 2);
        System.out.println("--------------------------------------------------");
        System.out.print("Escolha a opção desejada (1/2):");


        int choice = sc.nextInt();

        Personagem chosenCharacter = chooseYourCharacter(choice);

        System.out.println("--------------------------------------------------");

        sc.nextLine();

        pausa = sc.nextLine();

        printSlowly(Objects.requireNonNull(FileReader.readTxtFile("Texto2.txt")), 2);

        /* Comando para alterar armas
        escolha1.setWeapon(new Weapon(WeaponType.Lamina_De_Ferro_Reciclado, 50));
        System.out.println(escolha1);
        */

        System.out.println("--------------------------------------------------");

        if (chosenCharacter != null) {

            if (chosenCharacter instanceof DrMorato) {

                drMoratoStoryline(sc, chosenCharacter);

            }

            else if (chosenCharacter instanceof Liz) {

                lizStoryline(sc, chosenCharacter);

            }

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

    private void drMoratoStoryline (Scanner sc, Personagem character) {

        System.out.println(character);

        /*

            Insira a lore do personagem

        */

        droneVigiaFight(sc, character);

    }

    private void lizStoryline (Scanner sc, Personagem character) {

        System.out.println(character);

        /*

            Insira a lore do personagem

        */

        droneVigiaFight(sc, character);

    }

    private void droneVigiaFight (Scanner sc, Personagem character) {

        List<Mobs> drones = new ArrayList<>();
        drones.add(new Mobs("Drone Vigia #1", 30, 10, new None()));
        drones.add(new Mobs("Drone Vigia #2", 30, 10, new None()));
        drones.add(new Mobs("Drone Vigia #3", 30, 10, new None()));

        System.out.println(">>> Combate iniciado: " + character.getName() + " vs Drones de Vigilância");
        System.out.println();

        while (character.getLife() > 0 && drones.stream().anyMatch(drone -> drone.getLife() > 0)) {

            System.out.println("Status atual:");
            System.out.println(character.getName() + " - Vida: " + character.getLife());

            for (int i = 0; i < drones.size(); i++) {

                Mobs drone = drones.get(i);
                System.out.println((i + 1) + " - " + drone.getName() + " - Vida: " + drone.getLife());

            }

            System.out.println();

            System.out.println("Seu turno! Escolha uma ação:");
            System.out.println("1 - Atacar com arma");
            System.out.println("2 - Fugir");
            System.out.print("Opção: ");

            int option = sc.nextInt();

            switch (option) {

                case 1:

                    System.out.println("Escolha um drone para atacar:");

                    for (int i = 0; i < drones.size(); i++) {
                        Mobs drone = drones.get(i);
                        if (drone.getLife() > 0) {
                            System.out.println((i + 1) + " - " + drone.getName() + " (Vida: " + drone.getLife() + ")");
                        }

                    }

                    System.out.print("Opção: ");

                    int alvo = sc.nextInt() - 1;

                    if (alvo >= 0 && alvo < drones.size() && drones.get(alvo).getLife() > 0) {

                        int dano = 0;

                        if (character instanceof DrMorato) {

                            dano = ((DrMorato) character).getWeapon().getDamage();

                        } else if (character instanceof Liz) {

                            dano = ((Liz) character).getWeapon().getDamage();

                        }

                        Mobs droneAlvo = drones.get(alvo);

                        droneAlvo.setLife(Math.max(0, droneAlvo.getLife() - dano));

                        System.out.println("Você atacou " + droneAlvo.getName() + " causando " + dano + " de dano!");

                    } else {
                        System.out.println("Alvo inválido!");
                    }

                    break;

                case 2:
                    System.out.println(character.getName() + " fugiu da batalha!");
                    return;

            }

            for (Mobs drone : drones) {

                if (drone.getLife() > 0) {

                    System.out.println(drone.getName() + " ataca causando " + drone.getDamage() + " de dano!");

                    character.setLife(Math.max(0, character.getLife() - drone.getDamage()));

                    if (character.getLife() <= 0) {

                        break;

                    }

                }

            }

            System.out.println("------------------------------------");

        }

    }

    private void droneControleLeveFight () {}

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
