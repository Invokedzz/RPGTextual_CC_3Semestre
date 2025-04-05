package rpg.Jogo;

import rpg.model.Personagem.DrMorato;
import rpg.model.Personagem.Liz;

public class JogoRpg {

    public static void main (String[] args) {

        DrMorato morato = new DrMorato();

        Liz liz = new Liz();

        morato.status();

        System.out.println();

        liz.status();

        System.out.println(morato);

        System.out.println(liz);

    }

}
