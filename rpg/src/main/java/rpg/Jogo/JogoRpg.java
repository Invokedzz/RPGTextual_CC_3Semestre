package rpg.Jogo;

import rpg.Personagem.DrMorato;
import rpg.Personagem.Liz;

public class JogoRpg {
    public static void main(String[] args) {
        DrMorato morato = new DrMorato("Dr Morato");
        Liz liz = new Liz("Liz");

        morato.status();
        System.out.println();
        liz.status();





    }
}
