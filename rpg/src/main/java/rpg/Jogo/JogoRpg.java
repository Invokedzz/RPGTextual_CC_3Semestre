package rpg.Jogo;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import rpg.Personagem.DrMorato;
import rpg.Personagem.Liz;
import rpg.Util.ReadTxtFiles;

import static org.fusesource.jansi.Ansi.ansi;

public class JogoRpg {

    public static void main(String[] args) {

        DrMorato morato = new DrMorato("Dr Morato");
        Liz liz = new Liz("Liz");

        morato.status();
        System.out.println();
        liz.status();

        ReadTxtFiles.displayTxtFile("ascii-art (5).txt");

        System.out.println(morato);

        System.out.println(liz);

        System.out.println(ansi().eraseScreen().fg(Ansi.Color.GREEN).render("Show a green message"));


    }

}
