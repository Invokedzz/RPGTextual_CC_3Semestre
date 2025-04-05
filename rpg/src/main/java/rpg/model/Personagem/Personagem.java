package rpg.model.Personagem;

public class Personagem {

    private String name;

    private int life;

    private Weapon weapon;

    public Personagem (String name, int life, Weapon weapon) {

        this.name = name;

        this.life = life;

        this.weapon = weapon;

    }

    public String getName () {

        return name;

    }

    public void setName (String name) {

        this.name = name;

    }

    public int getLife () {

        return life;

    }

    public void setLife (int life) {

        this.life = life;

    }

    public Weapon getWeapon () {

        return weapon;

    }

    public void setWeapon (Weapon weapon) {

        this.weapon = weapon;

    }

    public void attack () {

        System.out.println(name + " ataca com " + weapon.getDamage()  + " de dano!");

    }

    public void damageReceived (Integer damage) {

        life -= damage;

        System.out.println(name + " recebeu " + damage + " de dano. Vida restante: " + life);

    }

    public void status () {

        System.out.println("Nome: "
                + name
                + " | Vida: "
                + life
                + " | Ataque: "
                + weapon.getDamage());

    }

    @Override
    public String toString() {

        return "Personagem{" +
                "name='" + name + '\'' +
                ", life=" + life +
                ", weapon=" + weapon +
                '}';

    }

}
