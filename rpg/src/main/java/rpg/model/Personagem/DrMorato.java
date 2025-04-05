package rpg.model.Personagem;

import rpg.model.enums.WeaponType;

public class DrMorato extends Personagem {

    public DrMorato () {

        super("Dr Morato", 130, new Weapon(WeaponType.WEAPON_2, 20));

    }

}
