package rpg.model.Personagem;

import rpg.model.enums.WeaponType;

public class Weapon {

    private WeaponType weaponType;

    private Integer damage;

    public Weapon (WeaponType weaponType, Integer damage) {

        this.weaponType = weaponType;

        this.damage = damage;

    }

    public WeaponType getWeaponType () {

        return weaponType;

    }

    public void setWeaponType (WeaponType weaponType) {

        this.weaponType = weaponType;

    }

    public Integer getDamage () {

        return damage;

    }

    public void setDamage (Integer damage) {

        this.damage = damage;

    }

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponType=" + weaponType +
                ", damage=" + damage +
                '}';
    }

}
