package rpg.Personagem;

import rpg.Personagem.enums.WeaponType;

public class Liz extends Personagem {
    public Liz(String name) {
        super("Liz", 100, new Weapon(WeaponType.WEAPON_2, 21));
    }


}
