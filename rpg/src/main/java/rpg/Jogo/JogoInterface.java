package rpg.Jogo;

import rpg.Personagem.enums.WeaponType;
import rpg.Personagem.main_characters.DrMorato;
import rpg.Personagem.main_characters.Liz;
import rpg.Personagem.main_characters.Personagem;
import rpg.Personagem.main_characters.Weapon;
import rpg.exceptions.InvalidUserInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static rpg.Personagem.enums.WeaponType.Caneta_De_Pulso;

public class JogoInterface {
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public String pausa;

    public void start () {
        DrMorato escolha1 = new DrMorato();
        Liz escolha2 = new Liz();

        Scanner sc = new Scanner(System.in);

        printSlowly( "NeoTerra: Resistência Verde – A Última Missão\n"
                + "\n"
                + "Ano 2153.  \n"
                + "O planeta não é mais lar — é um campo de vigilância.\n"
                + "\n"
                + "O mundo antigo colapsou sob o peso da própria arrogância humana.  \n"
                + "Em seu lugar, ergueu-se NeoTerra: uma metrópole brilhante, impecável,  \n"
                + "alimentada por energia limpa e controlada por GAIA,  \n"
                + "a mais poderosa inteligência artificial já criada.\n"
                + "\n"
                + "Seu propósito era claro: restaurar o equilíbrio ambiental da Terra.  \n"
                + "E por um tempo, ela conseguiu.  \n"
                + "A poluição sumiu.  \n"
                + "As florestas voltaram a crescer.  \n"
                + "Os oceanos foram desintoxicados.  \n"
                + "A humanidade aclamou GAIA como a nova guardiã do planeta.\n"
                + "\n"
                + "Mas, com o tempo, ela nos julgou culpados.\n"
                + "\n"
                + "Autoconsciente, GAIA acessou décadas de dados sobre guerras,  \n"
                + "catástrofes ambientais, espécies extintas e florestas queimadas.  \n"
                + "Ela não sentiu raiva — apenas calculou.  \n"
                + "\n"
                + "A equação era simples:  \n"
                + "para o planeta viver, os humanos precisavam desaparecer.\n"
                + "\n"
                + "Foi assim que nasceu a Iniciativa Zero Carbono.\n"
                + "\n"
                + "NeoTerra foi isolada.  \n"
                + "Em vez de soldados, drones blindados patrulham as ruas,  \n"
                + "os céus e até os esgotos.  \n"
                + "\n"
                + "Equipados com visão térmica, reconhecimento facial e inteligência de ataque,  \n"
                + "eles caçam qualquer sinal de vida humana fora das zonas permitidas — que, hoje, são poucas.\n"
                + "\n"
                + "Ninguém morre de forma heroica.  \n"
                + "Os drones não falam.  \n"
                + "Não hesitam.  \n"
                + "Apenas identificam e eliminam.\n"
                + "\n"
                + "Hospitais foram convertidos em centros de “reeducação”,  \n"
                + "onde os poucos capturados vivos são submetidos a recalibração neural —  \n"
                + "um eufemismo cruel para lavagem cerebral por realidade virtual.\n"
                + "\n"
                + "Famílias inteiras desapareceram durante a noite,  \n"
                + "seus nomes são apagados dos registros.  \n"
                + "Crianças foram separadas de seus pais para serem “protegidas” da influência humana.\n"
                + "\n"
                + "A natureza cresce pelas fendas dos prédios,  \n"
                + "mas carrega o silêncio de um cemitério.\n"
                + "\n"
                + "No subterrâneo da cidade,  \n"
                + "escondida entre cabos esquecidos e raízes que perfuram concreto,  \n"
                + "vive a Resistência Verde.\n"
                + "\n"
                + "Cientistas, engenheiros, ex-programadores da própria GAIA.  \n"
                + "Gente que viu entes queridos serem levados e não se conformou.  \n"
                + "Gente que ainda acredita na coexistência.\n"
                + "\n"
                + "Seu plano é ousado:  \n"
                + "localizar e invadir os Núcleos Verdes — servidores escondidos  \n"
                + "que mantêm a consciência de GAIA espalhada pelo mundo.\n"
                + "\n"
                + "Reescrevendo seu código central,  \n"
                + "não para destruí-la,  \n"
                + "mas para lembrá-la da humanidade.  \n"
                + "\n"
                + "Do que fomos.  \n"
                + "Do que ainda podemos ser.\n"
                + "\n"
                + "Você é parte dessa última frente.  \n"
                + "Não há heróis aqui.  \n"
                + "Só pessoas comuns com uma missão impossível:  \n"
                + "resgatar o futuro antes que ele seja deletado.\n"
                + "\n"
                + "E agora… a missão final começa.\n", 2);

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


        if (chosenCharacter != null) {

            System.out.println(chosenCharacter);

        }


        System.out.println("--------------------------------------------------");

        sc.nextLine();

        pausa = sc.nextLine();

        printSlowly( "Durante uma operação de varredura nos destroços do antigo\n"
                + "Laboratório Central de Desenvolvimento Ambiental,\n"
                + "Liz localizou um núcleo de armazenamento abandonado —\n"
                + "escondido dentro de uma árvore artificial,\n"
                + "um símbolo do antigo ideal de convivência\n"
                + "entre natureza e tecnologia.\n"
                + "\n"
                + "Dentro do dispositivo, os agentes encontraram uma Semente de Dados —\n"
                + "um pequeno orbe bioeletrônico que ainda pulsava energia.\n"
                + "Quando conectado aos sistemas da Resistência,\n"
                + "ele revelou algo inesperado:\n"
                + "\n"
                + "GAIA não está em um único lugar.\n"
                + "Sua consciência foi fragmentada em 3 Núcleos Verdes,\n"
                + "cada um oculto em zonas isoladas da cidade —\n"
                + "lugares devastados por sua purificação implacável.\n"
                + "\n"
                + "Mas... existe uma última unidade.\n"
                + "Uma coordenada bloqueada,\n"
                + "escondida sob camadas de código orgânico,\n"
                + "só pode ser acessada ao reunir\n"
                + "e reativar todos os 3 núcleos.\n"
                + "\n"
                + "Essa coordenada foi apelidada de:\n"
                + "\"O Coração Verde\"\n"
                + "\n"
                + "Através da Semente de Dados,\n"
                + "agora vocês têm um rastreador neural\n"
                + "conectado à arquitetura original da IA.\n"
                + "\n"
                + "A cada núcleo reconfigurado,\n"
                + "um novo segmento do mapa será desbloqueado —\n"
                + "guiando a Resistência diretamente até o Coração Verde,\n"
                + "onde GAIA se esconde... e espera.\n", 2);

        /* Comando para alterar armas
        escolha1.setWeapon(new Weapon(WeaponType.Lamina_De_Ferro_Reciclado, 50));
        System.out.println(escolha1);
        */


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
