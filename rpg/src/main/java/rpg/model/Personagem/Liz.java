package rpg.model.Personagem;

import rpg.model.enums.WeaponType;

public class Liz extends Personagem {

    public Liz () {

        super("Liz", 100, new Weapon(WeaponType.WEAPON_2, 10));

    }


}
