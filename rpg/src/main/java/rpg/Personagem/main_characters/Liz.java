package rpg.Personagem.main_characters;

import rpg.Personagem.enums.WeaponType;

public class Liz extends Personagem {

    public Liz () {

        super("Liz",
                150,
                new Weapon(WeaponType.LaminaDeFerroReciclado,
                        20));

    }


}
