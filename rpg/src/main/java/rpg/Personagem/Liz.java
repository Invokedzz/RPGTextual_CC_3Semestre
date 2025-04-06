package rpg.Personagem;

import rpg.Personagem.enums.WeaponType;

public class Liz extends Personagem {
    public Liz(String name) {
        super("Liz", 150, new Weapon(WeaponType.LançaChuvaBiologico, 20));
    }


}
