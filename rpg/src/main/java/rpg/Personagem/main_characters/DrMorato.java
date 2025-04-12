package rpg.Personagem.main_characters;

import rpg.Personagem.enums.WeaponType;

public class DrMorato extends Personagem {

    public DrMorato () {

        super("Dr Morato",
                100,
                new Weapon(WeaponType.CampoDeDistorcaoPortatil,
                        30));

    }

}
