package rpg.Personagem;

import rpg.Personagem.enums.WeaponType;

public class DrMorato extends Personagem {
    public DrMorato(String name) {
        super("Dr Morato", 100, new Weapon(WeaponType.GranadaNeblinaFertilizante, 30));
    }


}
