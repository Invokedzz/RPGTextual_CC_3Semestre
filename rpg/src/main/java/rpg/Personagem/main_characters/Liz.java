package rpg.Personagem.main_characters;

import rpg.Personagem.enums.WeaponType;

import static rpg.Jogo.JogoInterface.printSlowly;

public class Liz extends Personagem {

    public Liz () {

        super("Liz",
                150,
                new Weapon(WeaponType.LaminaDeFerroReciclado,
                        20));

    }

    public String escolha() {
        StringBuilder sb = new StringBuilder();

        sb.append("Opção 2: ");
        sb.append("Liz: Ofensiva, explosiva, intensa! \n ");
        sb.append("Ex-agente da NeoEnergy, Liz é impetuosa e determinada. \n ");
        sb.append("Acostumada ao confronto direto, ela causa alto dano aos inimigos, ");
        sb.append("mas sua impulsividade a deixa vulnerável.\n ");
        sb.append("Morato prefere agir com cautela. Seus ataques são mais fracos, ");
        sb.append("mas ele sofre menos dano dos inimigos por conhecer suas ");
        sb.append("fraquezas. \n");
        sb.append(" | Vida: ").append(getLife());
        sb.append(" | Dano: Alto");
        sb.append(" | Ataque: Alto \n");

        return sb.toString();
    }


}
