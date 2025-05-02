package rpg.Jogo;

import rpg.Personagem.enemies.Mobs;
import rpg.Personagem.enemies.Skill;
import rpg.Personagem.enemies.skills.None;
import rpg.Personagem.enemies.skills.Paralyze;
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

        character.setLife(character.getLife() + 90);

        droneControleLeveFight(sc, character);

        character.setLife(character.getLife() + 90);

        gaiaFight(sc, character);

    }

    private void lizStoryline (Scanner sc, Personagem character) {

        System.out.println(character);

        /*

            Insira a lore do personagem

        */

        droneVigiaFight(sc, character);

        character.setLife(character.getLife() + 30);

        droneControleLeveFight(sc, character);

        character.setLife(character.getLife() + 30);

        gaiaFight(sc, character);

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

    private void droneControleLeveFight (Scanner sc, Personagem character) {

        Mobs droneControle = new Mobs("Drone de Controle Leve", 50, 40, new Paralyze());
        boolean weaponLocked = false;
        int lockTurns = 0;

        System.out.println(">>> Combate iniciado: " + character.getName() + " vs " + droneControle.getName());
        System.out.println();

        while (character.getLife() > 0 && droneControle.getLife() > 0) {

            System.out.println("Status atual:");
            System.out.println(character.getName() + " - Vida: " + character.getLife());
            System.out.println(droneControle.getName() + " - Vida: " + droneControle.getLife());
            System.out.println();

            if (weaponLocked && lockTurns > 0) {
                System.out.println("Sua arma está travada e você não pode atacar neste turno!");
                lockTurns--;
            } else {
                System.out.println("Seu turno! Escolha uma ação:");
                System.out.println("1 - Atacar com arma");
                System.out.println("2 - Fugir");
                System.out.print("Opção: ");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        int dano = 0;
                        if (character instanceof DrMorato) {
                            dano = ((DrMorato) character).getWeapon().getDamage();
                        } else if (character instanceof Liz) {
                            dano = ((Liz) character).getWeapon().getDamage();
                        }

                        droneControle.setLife(Math.max(0, droneControle.getLife() - dano));
                        System.out.println("Você atacou causando " + dano + " de dano!");
                        break;

                    case 2:
                        System.out.println(character.getName() + " fugiu da batalha!");
                        return;

                    default:
                        System.out.println("Opção inválida.");
                }
            }

            if (droneControle.getLife() > 0) {
                System.out.println(droneControle.getName() + " ataca causando " + droneControle.getDamage() + " de dano!");
                character.setLife(Math.max(0, character.getLife() - droneControle.getDamage()));

                if (!weaponLocked && Math.random() < 0.3) {
                    droneControle.getSkill().use(character);
                    weaponLocked = true;
                    lockTurns = 1;
                    System.out.println(droneControle.getName() + " usou a habilidade: Travar Arma! Você perderá o próximo turno.");
                }
            }

            System.out.println("------------------------------------");
        }

        if (character.getLife() <= 0) {
            System.out.println(character.getName() + " foi derrotado.");
        } else {
            System.out.println(character.getName() + " venceu o combate!");
        }

    }

    private void gaiaFight(Scanner sc, Personagem character) {

        Mobs gaia = new Mobs("GAIA – Raiz Primária", 130, 10, new None()); // Ignora armadura por padrão
        List<Mobs> drones = new ArrayList<>();
        int turnCount = 0;

        System.out.println(">>> BOSS FIGHT: " + character.getName() + " vs " + gaia.getName());
        System.out.println("Descrição: A própria IA em sua forma digital/humana, protegida por um corpo energético e drones secundários.");
        System.out.println();

        while (character.getLife() > 0 && gaia.getLife() > 0) {
            turnCount++;

            System.out.println("========== TURNO " + turnCount + " ==========");
            System.out.println(character.getName() + " - Vida: " + character.getLife());
            System.out.println(gaia.getName() + " - Vida: " + gaia.getLife());

            for (int i = 0; i < drones.size(); i++) {
                Mobs drone = drones.get(i);
                if (drone.getLife() > 0) {
                    System.out.println("Drone Suporte #" + (i + 1) + " - Vida: " + drone.getLife());
                }
            }

            System.out.println();
            System.out.println("Seu turno! Escolha uma ação:");
            System.out.println("1 - Atacar GAIA");
            System.out.println("2 - Atacar Drone Suporte");
            System.out.println("3 - Fugir");
            System.out.print("Opção: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    int danoGaia = getDano(character);
                    gaia.setLife(Math.max(0, gaia.getLife() - danoGaia));
                    System.out.println("Você atacou GAIA causando " + danoGaia + " de dano!");
                    break;

                case 2:
                    List<Mobs> dronesVivos = drones.stream().filter(d -> d.getLife() > 0).toList();
                    if (dronesVivos.isEmpty()) {
                        System.out.println("Não há drones vivos para atacar!");
                    } else {
                        for (int i = 0; i < dronesVivos.size(); i++) {
                            System.out.println((i + 1) + " - Drone Suporte (Vida: " + dronesVivos.get(i).getLife() + ")");
                        }
                        System.out.print("Escolha o número do drone: ");
                        int droneIndex = sc.nextInt() - 1;
                        if (droneIndex >= 0 && droneIndex < dronesVivos.size()) {
                            Mobs alvo = dronesVivos.get(droneIndex);
                            int dano = getDano(character);
                            alvo.setLife(Math.max(0, alvo.getLife() - dano));
                            System.out.println("Você atacou o drone causando " + dano + " de dano!");
                        } else {
                            System.out.println("Drone inválido!");
                        }
                    }
                    break;

                case 3:
                    System.out.println(character.getName() + " fugiu da batalha!");
                    return;

                default:
                    System.out.println("Ação inválida.");
            }

            if (gaia.getLife() > 0) {
                System.out.println("GAIA usa Pulso Zero Carbono e causa " + gaia.getDamage() + " de dano ignorando armaduras!");
                character.setLife(Math.max(0, character.getLife() - gaia.getDamage()));
            }

            for (Mobs drone : drones) {
                if (drone.getLife() > 0) {
                    if (Math.random() < 0.5 && gaia.getLife() > 0) {

                        gaia.setLife(Math.min(100, gaia.getLife() + 10));
                        System.out.println(drone.getName() + " cura GAIA em +10 de vida!");
                    } else {

                        System.out.println(drone.getName() + " ataca causando 10 de dano!");
                        character.setLife(Math.max(0, character.getLife() - 10));
                    }
                }
            }

            if (turnCount % 2 == 0) {
                Mobs novoDrone = new Mobs("Drone Suporte de GAIA", 30, 10, new None());
                drones.add(novoDrone);
                System.out.println("Um novo Drone Suporte apareceu!");
            }

            if (turnCount % 3 == 0 && gaia.getLife() > 0) {
                gaia.setLife(Math.min(100, gaia.getLife() + 20));
                System.out.println("GAIA ativa Regeneração Ambiental! +20 de vida.");
            }

            System.out.println("--------------------------------------");
        }

        if (character.getLife() <= 0) {
            System.out.println(character.getName() + " foi derrotado...");
        } else {
            System.out.println(character.getName() + " derrotou GAIA – Raiz Primária!");
        }
    }

    private int getDano(Personagem character) {
        if (character instanceof DrMorato) {
            return ((DrMorato) character).getWeapon().getDamage();
        } else if (character instanceof Liz) {
            return ((Liz) character).getWeapon().getDamage();
        }
        return 10; // default
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
