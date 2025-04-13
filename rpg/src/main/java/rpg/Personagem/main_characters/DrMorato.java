package rpg.Personagem.main_characters;

import rpg.Personagem.enums.WeaponType;

import static rpg.Jogo.JogoInterface.printSlowly;
import static rpg.Jogo.JogoInterface.printSlowlyWithSound;

public class DrMorato extends Personagem {

    public DrMorato () {

        super("Dr Morato",
                130,
                new Weapon(WeaponType.CampoDeDistorcaoPortatil,
                        30));

    }

    public String escolha() {
        StringBuilder sb = new StringBuilder();

        sb.append(" Opção 1: ");
        sb.append("Dr. Morato: Preciso, analítico, evasivo! \n ");
        sb.append("Por conhecer a arquitetura da IA GAIA, Morato sabe ");
        sb.append("como se mover sem ser detectado. Ele não é tão forte quanto ");
        sb.append("Liz, mas sabe evitar o pior com inteligência e precisão.\n ");
        sb.append("Morato prefere agir com cautela. ");
        sb.append("Seus ataques são mais fracos, ");
        sb.append("mas ele sofre menos dano dos inimigos por conhecer suas ");
        sb.append("fraquezas. \n");
        sb.append(" | Vida: ").append(getLife());
        sb.append(" | Dano: Baixo");
        sb.append(" | Ataque: Baixo \n");



        return sb.toString();
    }
}
