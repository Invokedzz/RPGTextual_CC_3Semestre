package rpg.Personagem;

import rpg.Personagem.enums.WeaponType;

public class DrMorato extends Personagem {
    public DrMorato(String name) {
        super("Dr Morato", 130, new Weapon(WeaponType.WEAPON_1, 10));
    }


}
